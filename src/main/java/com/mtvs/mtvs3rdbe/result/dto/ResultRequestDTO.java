package com.mtvs.mtvs3rdbe.result.dto;

import com.mtvs.mtvs3rdbe.result.domain.SimulatorRole;

public class ResultRequestDTO {

    public record saveDTO(
            String playTime,
            int itemCount,
            int missionSuccessCount,
            Long userId,
            SimulatorRole role
    ) {}

}
