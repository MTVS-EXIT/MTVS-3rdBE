package com.mtvs.mtvs3rdbe.result.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private int mission_success_count;
    private Long userId;

    @Builder
    public Result(String playTime, int itemCount, int mission_success_count, Long userId) {
        this.playTime = playTime;
        this.itemCount = itemCount;
        this.mission_success_count = mission_success_count;
        this.userId = userId;
    }
}
