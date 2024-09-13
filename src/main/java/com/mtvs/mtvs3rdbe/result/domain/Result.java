package com.mtvs.mtvs3rdbe.result.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long id;

    private String playTime;
    private int itemCount;
    private int missionSuccessCount;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private SimulatorRole simulatorRole;

    @Builder
    public Result(String playTime, int itemCount, int missionSuccessCount, Long userId, SimulatorRole simulatorRole) {
        this.playTime = playTime;
        this.itemCount = itemCount;
        this.missionSuccessCount = missionSuccessCount;
        this.userId = userId;
        this.simulatorRole = simulatorRole;
    }
}
