package com.mtvs.mtvs3rdbe.user.service;

import com.mtvs.mtvs3rdbe.jwt.JWTTokenProvider;
import com.mtvs.mtvs3rdbe.redis.domain.RefreshToken;
import com.mtvs.mtvs3rdbe.redis.repository.RefreshTokenRedisRepository;
import com.mtvs.mtvs3rdbe.user.domain.User;
import com.mtvs.mtvs3rdbe.user.dto.UserCreateRequestDTO;
import com.mtvs.mtvs3rdbe.user.dto.UserRequestDTO;
import com.mtvs.mtvs3rdbe.user.dto.UserResponseDTO;
import com.mtvs.mtvs3rdbe.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
//    private final AuthenticationManager authenticationManager;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;
    private final JWTTokenProvider jwtTokenProvider;

    // raw password db 저장 메소드
    public void save(UserCreateRequestDTO userCreateRequestDTO) {
        User user = User.builder()
                .loginId(userCreateRequestDTO.getLoginId())
                .password(userCreateRequestDTO.getPassword())
                .nickname(userCreateRequestDTO.getNickname()).build();

        userRepository.save(user);
    }

    // user 아이디로 user 객체 삭제
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    // 회원가입 메소드 (nickname 중복 확인 로직 추가)
    public void signUp(UserRequestDTO.signUpDTO signUpDTO) {
        // 로그인 아이디 중복 확인
        checkDuplicatedLoginId(signUpDTO.loginId());

        // nickname 중복 확인

        // 회원 생성
        User user = User.builder()
                .loginId(signUpDTO.loginId())
                .password(passwordEncoder.encode(signUpDTO.password()))
                .nickname(signUpDTO.nickname())
                .build();

        // 회원 저장
        userRepository.save(user);
    }

    // 로그인 메소드
    public UserResponseDTO.authTokenDTO login(UserRequestDTO.loginDTO loginDTO) {
        User user = userRepository.findByLoginId(loginDTO.loginId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        checkValidPassword(loginDTO.password(), user.getPassword());

        return getAuthTokenDTO(loginDTO.loginId(), loginDTO.password());
    }

    // 로그아웃
    public void logout(HttpServletRequest httpServletRequest) {
        String token = jwtTokenProvider.resolveToken(httpServletRequest);

        if (token != null || !jwtTokenProvider.validateToken(token)) {
            throw new IllegalStateException("유효하지 않은 Refresh Token 입니다.");
        }

        RefreshToken refreshToken = refreshTokenRedisRepository.findByRefreshToken(token);
        refreshTokenRedisRepository.delete(refreshToken);
    }

    // refresh token 발급
    public UserResponseDTO.authTokenDTO reissueToken(HttpServletRequest httpServletRequest) {

        // Request Header 에서 JWT Token 추출
        String token = jwtTokenProvider.resolveToken(httpServletRequest);

        // 토큰 유효성 검사
        if(token == null || !jwtTokenProvider.validateToken(token)) {
            throw new IllegalStateException("유효하지 않은 Access Token 입니다.");
        }

        // type 확인
        if(!jwtTokenProvider.isRefreshToken(token)) {
            throw new IllegalStateException("유효하지 않은 Refresh Token 입니다.");
        }

        // RefreshToken
        RefreshToken refreshToken = refreshTokenRedisRepository.findByRefreshToken(token);

        if(refreshToken == null) {
            throw new IllegalStateException("Refresh Token 이 비어있습니다.");
        }

        // Redis 에 저장된 RefreshToken 정보를 기반으로 JWT Token 생성
        UserResponseDTO.authTokenDTO authTokenDTO = jwtTokenProvider.generateToken(
                refreshToken.getId(), refreshToken.getAuthorities()
        );

        // Redis 에 RefreshToken Update
        refreshTokenRedisRepository.save(RefreshToken.builder()
                .id(refreshToken.getId())
                .authorities(refreshToken.getAuthorities())
                .refreshToken(authTokenDTO.refreshToken())
                .build());

        return authTokenDTO;
    }

    // access 토큰 발급
    protected UserResponseDTO.authTokenDTO getAuthTokenDTO(String loginId, String password) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginId, password);

        System.out.println("usernamePasswordAuthenticationToken = " + usernamePasswordAuthenticationToken);

        AuthenticationManager manager = authenticationManagerBuilder.getObject();

//        AuthenticationManager manager = authenticationManager(authenticationConfiguration);

        System.out.println("manager = " + manager);

        Authentication authentication = manager.authenticate(usernamePasswordAuthenticationToken);

        UserResponseDTO.authTokenDTO authTokenDTO = jwtTokenProvider.generateToken(authentication);

        refreshTokenRedisRepository.save(RefreshToken.builder()
                .id(authentication.getName())
                .authorities(authentication.getAuthorities())
                .refreshToken(authTokenDTO.refreshToken())
                .build()
        );

        return authTokenDTO;
    }

    private void checkValidPassword(String loginDtoPassword, String dbPassword) {
        if (!passwordEncoder.matches(loginDtoPassword, dbPassword)) {
            throw new BadCredentialsException("Invalid password");
        }

    }

    private void checkDuplicatedLoginId(String loginId) {
        Optional<User> user = userRepository.findByLoginId(loginId);

        if (user.isPresent()) {
            throw new IllegalArgumentException("중복 된 아이디 입니다.");
        }
    }



}
