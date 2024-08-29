package com.mtvs.mtvs3rdbe.user.repository;

import com.mtvs.mtvs3rdbe.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
