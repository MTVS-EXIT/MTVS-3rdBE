package com.mtvs.mtvs3rdbe.user.controller;

import com.mtvs.mtvs3rdbe.user.dto.UserRequestDTO;
import com.mtvs.mtvs3rdbe.user.dto.UserResponseDTO;
import com.mtvs.mtvs3rdbe.user.service.UserAuthService;
import com.mtvs.mtvs3rdbe.user.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        System.out.println("login 로직 통과 ------------");
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, responseDTO.grantType() + " " + responseDTO.accessToken())
                .header("Refresh-Token", responseDTO.grantType() + " " + responseDTO.refreshToken())
                .body(ApiUtils.success(null));
    }
}
