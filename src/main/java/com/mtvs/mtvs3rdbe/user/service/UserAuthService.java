package com.mtvs.mtvs3rdbe.user.service;

import com.mtvs.mtvs3rdbe.jwt.JWTTokenProvider;
import com.mtvs.mtvs3rdbe.redis.repository.RefreshTokenRedisRepository;
import com.mtvs.mtvs3rdbe.user.domain.User;
import com.mtvs.mtvs3rdbe.user.dto.UserCreateRequestDTO;
import com.mtvs.mtvs3rdbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class UserAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
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
    public void signUp(UserCreateRequestDTO userCreateRequestDTO) {
        // 로그인 아이디 중복 확인
        checkDuplicatedLoginId(userCreateRequestDTO.getLoginId());

        // nickname 중복 확인

        // 회원 생성
        User user = User.builder()
                .loginId(userCreateRequestDTO.getLoginId())
                .password(passwordEncoder.encode(userCreateRequestDTO.getPassword()))
                .nickname(userCreateRequestDTO.getNickname())
                .build();

        // 회원 저장
        userRepository.save(user);
    }

    private void checkDuplicatedLoginId(String loginId) {
        Optional<User> user = userRepository.findByLoginId(loginId);

        if (user.isPresent()) {
            throw new IllegalArgumentException("중복 된 아이디 입니다.");
        }
    }


}
