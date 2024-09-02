package com.mtvs.mtvs3rdbe.result.repository;


import com.mtvs.mtvs3rdbe.result.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
