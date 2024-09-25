package com.mtvs.mtvs3rdbe.rank.repository;

import com.mtvs.mtvs3rdbe.rank.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Long> {
}
