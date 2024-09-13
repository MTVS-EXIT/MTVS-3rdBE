package com.mtvs.mtvs3rdbe.dronesavepoint.service;

import com.mtvs.mtvs3rdbe.humansavepoint.repository.HumanSavePointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DroneSavePointService {
    private final HumanSavePointRepository humanSavePointRepository;
}
