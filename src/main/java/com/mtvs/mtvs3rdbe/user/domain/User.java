package com.mtvs.mtvs3rdbe.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String loginId;
    private String password;
    private String nickname;
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'USER'")
    private Authority authority;
    private LocalDateTime createAt;

    @Builder
    public User(String loginId, String password, String nickname, LocalDateTime createAt) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.authority = Authority.USER;
        this.createAt = createAt;
    }

}
