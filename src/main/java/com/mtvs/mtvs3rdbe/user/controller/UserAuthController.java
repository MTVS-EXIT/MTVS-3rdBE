package com.mtvs.mtvs3rdbe.user.controller;

import com.mtvs.mtvs3rdbe.user.dto.UserRequestDTO;
import com.mtvs.mtvs3rdbe.user.dto.UserResponseDTO;
import com.mtvs.mtvs3rdbe.user.service.UserAuthService;
import com.mtvs.mtvs3rdbe.user.utils.ApiUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    private final UserAuthService userAuthService;

    @PostMapping("signup")
    public ResponseEntity<?> signUp(@RequestBody UserRequestDTO.signUpDTO signUpDTO) {
        userAuthService.signUp(signUpDTO);

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO.loginDTO loginDTO) {
        UserResponseDTO.authTokenDTO responseDTO = userAuthService.login(loginDTO);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, responseDTO.grantType() + " " + responseDTO.accessToken())
                .header("Refresh-Token", responseDTO.grantType() + " " + responseDTO.refreshToken())
                .body(ApiUtils.success(null));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest) {
        userAuthService.logout(httpServletRequest);

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissueToken(HttpServletRequest httpServletRequest) {

        UserResponseDTO.authTokenDTO responseDTO = userAuthService.reissueToken(httpServletRequest);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, responseDTO.grantType() + " " + responseDTO.accessToken())
                .header("Refresh-Token", responseDTO.grantType() + " " + responseDTO.refreshToken())
                .body(ApiUtils.success(null));
    }
}
