package com.mtvs.mtvs3rdbe.rank.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private Long id;

    private String playtime;
    private Integer room;
    private Integer item;
    private Integer damage;

    private LocalDateTime saveAt;

    @Builder
    public Rank(String playtime, Integer room, Integer item, Integer damage, LocalDateTime saveAt) {
        this.playtime = playtime;
        this.room = room;
        this.item = item;
        this.damage = damage;
        this.saveAt = saveAt;
    }
}
