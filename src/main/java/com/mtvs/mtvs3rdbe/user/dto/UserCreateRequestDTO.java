package com.mtvs.mtvs3rdbe.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public class UserCreateRequestDTO {

    private String loginId;
    private String password;
    private String nickname;

}
