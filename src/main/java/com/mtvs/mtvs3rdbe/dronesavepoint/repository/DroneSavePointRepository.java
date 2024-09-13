package com.mtvs.mtvs3rdbe.dronesavepoint.repository;

import com.mtvs.mtvs3rdbe.humansavepoint.domain.HumanSavePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneSavePointRepository extends JpaRepository<HumanSavePoint, Long> {
}
