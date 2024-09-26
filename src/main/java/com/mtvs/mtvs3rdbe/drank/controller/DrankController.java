package com.mtvs.mtvs3rdbe.drank.controller;

import com.mtvs.mtvs3rdbe.drank.domain.Drank;
import com.mtvs.mtvs3rdbe.drank.domain.DrankRequestDTO;
import com.mtvs.mtvs3rdbe.drank.repository.DrankRepository;
import com.mtvs.mtvs3rdbe.drank.service.DrankService;
import com.mtvs.mtvs3rdbe.rank.domain.Rank;
import com.mtvs.mtvs3rdbe.user.utils.ApiUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        System.out.println("dto = " + dto);
        drankService.save(dto);
        return ResponseEntity.ok().body(ApiUtils.success("드론 결과가 성공적으로 저장 되었습니다."));
    }

    @GetMapping("/dranks")
    public ResponseEntity<?> getAllDranks() {
        Pageable pageable = PageRequest.of(0, 100);
        List<Drank> dranks = drankService.findRanks(pageable);
        return ResponseEntity.ok().body(ApiUtils.success(dranks));
    }

}
