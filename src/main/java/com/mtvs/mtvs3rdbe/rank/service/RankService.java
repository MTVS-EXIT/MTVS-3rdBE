package com.mtvs.mtvs3rdbe.rank.service;

import com.mtvs.mtvs3rdbe.rank.domain.Rank;
import com.mtvs.mtvs3rdbe.rank.domain.RankRequestDTO;
import com.mtvs.mtvs3rdbe.rank.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;

    public void save(RankRequestDTO dto) {
        Rank rank = Rank.builder()
                .item(dto.getItem())
                .room(dto.getRoom())
                .playtime(dto.getPlaytime())
                .damage(dto.getDamage()).build();
        rankRepository.save(rank);
    }

    public List<Rank> findAll() {
        return rankRepository.findAll();
    }
}
