package com.mtvs.mtvs3rdbe.redis.repository;

import com.mtvs.mtvs3rdbe.redis.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, Long> {

    RefreshToken findByRefreshToken(String refreshToken);
}