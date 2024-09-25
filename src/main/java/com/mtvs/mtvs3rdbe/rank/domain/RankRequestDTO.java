package com.mtvs.mtvs3rdbe.rank.domain;

import lombok.Data;

@Data
public class RankRequestDTO {
    private String playtime;
    private Integer room;
    private Integer item;
    private Integer damage;
}
