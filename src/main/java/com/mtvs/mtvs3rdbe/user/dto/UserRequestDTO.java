package com.mtvs.mtvs3rdbe.user.dto;

public class UserRequestDTO {

    public record loginDTO(
            String loginId,
            String password
    ) {
    }

    public record signUpDTO(
            String loginId,
            String password,
            String nickname
    ) {
    }
}
