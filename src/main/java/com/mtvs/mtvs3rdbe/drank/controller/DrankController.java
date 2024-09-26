package com.mtvs.mtvs3rdbe.drank.controller;

import com.mtvs.mtvs3rdbe.drank.domain.DrankRequestDTO;
import com.mtvs.mtvs3rdbe.drank.repository.DrankRepository;
import com.mtvs.mtvs3rdbe.drank.service.DrankService;
import com.mtvs.mtvs3rdbe.rank.domain.Rank;
import com.mtvs.mtvs3rdbe.user.utils.ApiUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DrankController {
    private final DrankService drankService;

    @PostMapping("/drank")
    public ResponseEntity<?> saveDrank(@RequestBody DrankRequestDTO.saveDTO dto) {
        drankService.save(dto);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
