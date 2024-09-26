package com.mtvs.mtvs3rdbe.rank.controller;

import com.mtvs.mtvs3rdbe.rank.domain.Rank;
import com.mtvs.mtvs3rdbe.rank.domain.RankRequestDTO;
import com.mtvs.mtvs3rdbe.rank.service.RankService;
import com.mtvs.mtvs3rdbe.user.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RankController {
    private final RankService rankService;

    @PostMapping("/rank")
    public ResponseEntity<?> save(@RequestBody RankRequestDTO dto) {
        rankService.save(dto);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @GetMapping("/ranks")
    public ResponseEntity<?> ranks() {
        List<Rank> ranks = rankService.findAll();
        return ResponseEntity.ok().body(ApiUtils.success(ranks));
    }
}
