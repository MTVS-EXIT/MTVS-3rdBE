package com.mtvs.mtvs3rdbe.savepoint.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_save_point")
public class SavePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "save_point_id")
    private Long id;

    private String playTime;
    private String location;
    private String item;
    private Long userId;

    @Builder
    public SavePoint(String playTime, String location, String item, Long userId) {
        this.playTime = playTime;
        this.location = location;
        this.item = item;
        this.userId = userId;
    }
}
