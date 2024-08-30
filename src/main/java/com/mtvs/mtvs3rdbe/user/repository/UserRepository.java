package com.mtvs.mtvs3rdbe.user.repository;

import com.mtvs.mtvs3rdbe.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginId(String loginId);

}
