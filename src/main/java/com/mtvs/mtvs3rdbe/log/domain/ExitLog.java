package com.mtvs.mtvs3rdbe.log.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_exit_log")
public class ExitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exit_log_id")
    private Long id;

    private String type;
    private String content;
    private LocalDateTime saveAt;
    private Long userId;

    @Builder
    public ExitLog(String type, String content, LocalDateTime saveAt, Long userId) {
        this.type = type;
        this.content = content;
        this.saveAt = saveAt;
        this.userId = userId;
    }
}
