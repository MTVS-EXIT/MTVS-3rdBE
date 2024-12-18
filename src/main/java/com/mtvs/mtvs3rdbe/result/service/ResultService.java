package com.mtvs.mtvs3rdbe.result.service;

import com.mtvs.mtvs3rdbe.result.domain.Result;
import com.mtvs.mtvs3rdbe.result.domain.SimulatorRole;
import com.mtvs.mtvs3rdbe.result.repository.ResultRepository;
import com.mtvs.mtvs3rdbe.result.dto.ResultRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
                .simulatorRole(dto.simulatorRole())
                .build();

        resultRepository.save(result);
    }

    public List<Result> findAll() {
        return resultRepository.findAll();
    }
}
