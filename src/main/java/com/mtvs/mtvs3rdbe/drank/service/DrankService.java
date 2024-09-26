package com.mtvs.mtvs3rdbe.drank.service;

import com.mtvs.mtvs3rdbe.drank.domain.Drank;
import com.mtvs.mtvs3rdbe.drank.domain.DrankRequestDTO;
import com.mtvs.mtvs3rdbe.drank.repository.DrankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class DrankService {
    private final DrankRepository drankRepository;

    public void save(DrankRequestDTO.saveDTO dto) {
        Drank drank = Drank.builder()
                .detection(dto.detection())
                .safe(dto.safe())
                .caution(dto.caution())
                .danger(dto.danger())
                .saveAt(LocalDateTime.now())
                .userNickname(dto.userNickname())
                .build();

        drankRepository.save(drank);
    }
}
