package com.mtvs.mtvs3rdbe.log.service;

import com.mtvs.mtvs3rdbe.log.repository.ExitLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExitLogService {
    private final ExitLogRepository exitLogRepository;

}
