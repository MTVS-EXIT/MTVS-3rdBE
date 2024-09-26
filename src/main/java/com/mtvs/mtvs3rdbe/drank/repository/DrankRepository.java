package com.mtvs.mtvs3rdbe.drank.repository;

import com.mtvs.mtvs3rdbe.drank.domain.Drank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrankRepository extends JpaRepository<Drank, Long> {
}
