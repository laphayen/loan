package com.laphayen.loan.controller;

import com.laphayen.loan.dto.CounselDTO;
import com.laphayen.loan.dto.ResponseDTO;
import com.laphayen.loan.service.CounselService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counsels")
public class CounselController extends AbstractController {

    private final CounselService counselService;

    @PostMapping
    public ResponseDTO<CounselDTO.Response> create(@RequestBody CounselDTO.Request request) {
        return ok(counselService.create(request));
    }

}
