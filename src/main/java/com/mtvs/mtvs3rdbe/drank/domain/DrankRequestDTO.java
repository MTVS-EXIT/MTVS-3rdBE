package com.mtvs.mtvs3rdbe.drank.domain;

public class DrankRequestDTO {
    public record saveDTO(
            String playtime,
            Integer detection,
            Integer danger,
            Integer caution,
            Integer safe,
            String userNickname
    ){}
}
