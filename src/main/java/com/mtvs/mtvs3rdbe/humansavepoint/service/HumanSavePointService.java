package com.mtvs.mtvs3rdbe.humansavepoint.service;

import com.mtvs.mtvs3rdbe.humansavepoint.repository.HumanSavePointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HumanSavePointService {
    private final HumanSavePointRepository humanSavePointRepository;
}
