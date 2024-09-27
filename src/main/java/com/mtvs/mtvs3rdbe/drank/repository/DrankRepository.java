package com.mtvs.mtvs3rdbe.drank.repository;

import com.mtvs.mtvs3rdbe.drank.domain.Drank;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrankRepository extends JpaRepository<Drank, Long> {

    @Query("SELECT d FROM Drank d WHERE d.userNickname IS NOT NULL AND d.playtime IS NOT NULL ORDER BY d.playtime ASC")
    List<Drank> findTop100ByPlaytimeAsc(Pageable pageable);
}
