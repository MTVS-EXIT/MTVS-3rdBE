package com.mtvs.mtvs3rdbe.log.repository;

import com.mtvs.mtvs3rdbe.log.domain.ExitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExitLogRepository extends JpaRepository<ExitLog, Long> {
}
