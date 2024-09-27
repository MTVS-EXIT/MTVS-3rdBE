package com.mtvs.mtvs3rdbe.drank.service;

import com.mtvs.mtvs3rdbe.drank.domain.Drank;
import com.mtvs.mtvs3rdbe.drank.domain.DrankRequestDTO;
import com.mtvs.mtvs3rdbe.drank.repository.DrankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DrankService {
    private final DrankRepository drankRepository;

    public void save(DrankRequestDTO.saveDTO dto) {
        Drank drank;
        if (dto.userNickname() == null) {
            drank = Drank.builder()
                    .playtime(dto.playtime())
                    .detection(dto.detection())
                    .safe(dto.safe())
                    .caution(dto.caution())
                    .danger(dto.danger())
                    .saveAt(LocalDateTime.now())
                    .userNickname("none")
                    .build();
        } else {
            drank = Drank.builder()
                    .playtime(dto.playtime())
                    .detection(dto.detection())
                    .safe(dto.safe())
                    .caution(dto.caution())
                    .danger(dto.danger())
                    .saveAt(LocalDateTime.now())
                    .userNickname(dto.userNickname())
                    .build();
        }


        drankRepository.save(drank);
    }

    public List<Drank> findAll() {
        return drankRepository.findAll();
    }

    public List<Drank> findRanks(Pageable pageable) {
        return drankRepository.findTop100ByPlaytimeAsc(pageable);
    }
}
