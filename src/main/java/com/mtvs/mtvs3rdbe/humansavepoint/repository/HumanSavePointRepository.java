package com.mtvs.mtvs3rdbe.humansavepoint.repository;

import com.mtvs.mtvs3rdbe.humansavepoint.domain.HumanSavePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanSavePointRepository extends JpaRepository<HumanSavePoint, Long> {
}
