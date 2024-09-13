package com.mtvs.mtvs3rdbe.result.controller;

import com.mtvs.mtvs3rdbe.result.domain.Result;
import com.mtvs.mtvs3rdbe.result.dto.ResultRequestDTO;
import com.mtvs.mtvs3rdbe.result.service.ResultService;
import com.mtvs.mtvs3rdbe.user.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/result")
@RestController
public class ResultController {
    private final ResultService resultService;

    @PostMapping("/save")
    public ResponseEntity<?> save(ResultRequestDTO.saveDTO dto) {
        resultService.save(dto);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // paging 처리 (필요하다면)
    @GetMapping("/")
    public ResponseEntity<?> findResult() {
        List<Result> resultList = resultService.findAll();
        return ResponseEntity.ok().body(ApiUtils.success(resultList));
    }
}
