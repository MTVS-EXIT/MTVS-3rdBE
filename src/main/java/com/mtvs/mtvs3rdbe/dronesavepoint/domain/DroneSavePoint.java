package com.mtvs.mtvs3rdbe.dronesavepoint.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_drone_save_point")
public class DroneSavePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drone_save_point_id")
    private Long id;

    private String playTime;
    private String location;
    private Long userId;

    @Builder
    public DroneSavePoint(String playTime, String location, Long userId) {
        this.playTime = playTime;
        this.location = location;
        this.userId = userId;
    }
}
