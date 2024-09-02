package com.mtvs.mtvs3rdbe.savepoint.service;

import com.mtvs.mtvs3rdbe.savepoint.repository.SavePointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SavePointService {
    private final SavePointRepository savePointRepository;
}
