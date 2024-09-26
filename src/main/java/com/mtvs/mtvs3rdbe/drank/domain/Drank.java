package com.mtvs.mtvs3rdbe.drank.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_drank")
public class Drank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drank_id")
    private Long id;

    private String playtime;
    private Integer detection;
    private Integer danger;
    private Integer caution;
    private Integer safe;
    private String userNickname;

    private LocalDateTime saveAt;

    @Builder
    public Drank(String playtime, Integer detection, Integer danger, Integer caution, Integer safe, String userNickname, LocalDateTime saveAt) {
        this.playtime = playtime;
        this.detection = detection;
        this.danger = danger;
        this.caution = caution;
        this.safe = safe;
        this.userNickname = userNickname;
        this.saveAt = saveAt;
    }

}
