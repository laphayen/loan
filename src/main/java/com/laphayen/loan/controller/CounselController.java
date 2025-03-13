package com.laphayen.loan.controller;

import com.laphayen.loan.dto.CounselDTO;
import com.laphayen.loan.dto.ResponseDTO;
import com.laphayen.loan.service.CounselService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counsels")
public class CounselController extends AbstractController {

    private final CounselService counselService;

    // 대출 상담 등록
    @PostMapping
    public ResponseDTO<CounselDTO.Response> create(@RequestBody CounselDTO.Request request) {
        return ok(counselService.create(request));
    }

    // 대출 상담 전체 조회
    @GetMapping
    public ResponseDTO<List<CounselDTO.Response>> list() {
        return ok(counselService.getlist());
    }

    // 대출 상담 아이디 조회 - 단일
    @GetMapping("/{counselId}")
    public ResponseDTO<CounselDTO.Response> get(@PathVariable Long counselId) {
        return ok(counselService.get(counselId));
    }

    // 대출 상담 수정
    @PutMapping("/{counselId}")
    public ResponseDTO<CounselDTO.Response> update(@PathVariable Long counselId, @RequestBody CounselDTO.Request request) {
        return ok(counselService.update(counselId, request));
    }

    
}
