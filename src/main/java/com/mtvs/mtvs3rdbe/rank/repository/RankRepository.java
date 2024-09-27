package com.mtvs.mtvs3rdbe.rank.repository;

import com.mtvs.mtvs3rdbe.drank.domain.Drank;
import com.mtvs.mtvs3rdbe.rank.domain.Rank;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankRepository extends JpaRepository<Rank, Long> {
    @Query("SELECT r FROM Rank r WHERE r.userNickname IS NOT NULL AND r.playtime IS NOT NULL ORDER BY r.playtime ASC")
    List<Rank> findByPlaytimeAsc(Pageable pageable);
}
