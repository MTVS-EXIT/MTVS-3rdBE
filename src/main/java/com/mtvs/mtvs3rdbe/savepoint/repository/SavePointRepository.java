package com.mtvs.mtvs3rdbe.savepoint.repository;

import com.mtvs.mtvs3rdbe.savepoint.domain.SavePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavePointRepository extends JpaRepository<SavePoint, Long> {
}
