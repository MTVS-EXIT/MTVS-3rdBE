package com.mtvs.mtvs3rdbe.result.service;

import com.mtvs.mtvs3rdbe.result.domain.Result;
import com.mtvs.mtvs3rdbe.result.repository.ResultRepository;
import com.mtvs.mtvs3rdbe.result.dto.ResultRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;

    public void save(ResultRequestDTO.saveDTO dto) {
        Result result = Result.builder()
                .playTime(dto.playTime())
                .itemCount(dto.itemCount())
                .missionSuccessCount(dto.missionSuccessCount())
                .userId(dto.userId())
                .simulatorRole(dto.role())
                .build();

        resultRepository.save(result);
    }

}
