package com.mtvs.mtvs3rdbe.result.service;

import com.mtvs.mtvs3rdbe.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;


}
