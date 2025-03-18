package com.laphayen.loan.controller;

import com.laphayen.loan.dto.ApplicationDTO;
import com.laphayen.loan.dto.ResponseDTO;
import com.laphayen.loan.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController extends AbstractController {

    private final ApplicationService applicationService;

    // 대출 신청 등록
    @PostMapping
    public ResponseDTO<ApplicationDTO.Response> create(@RequestBody ApplicationDTO.Request request) {
        return ok(applicationService.create(request));
    }

    // 대출 신청 전체 조회
    @GetMapping
    public ResponseDTO<List<ApplicationDTO.Response>> list() {
        return ok(applicationService.getlist());
    }

    // 대출 신청 아이디 조회 - 단일
    @GetMapping("/{ApplicationId}")
    public ResponseDTO<ApplicationDTO.Response> get(@PathVariable Long ApplicationId) {
        return ok(applicationService.get(ApplicationId));
    }


}
