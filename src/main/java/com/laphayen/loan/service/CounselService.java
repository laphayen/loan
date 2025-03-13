package com.laphayen.loan.service;

import com.laphayen.loan.dto.CounselDTO;

import java.util.List;

public interface CounselService {

    CounselDTO.Response create(CounselDTO.Request request);

    CounselDTO.Response get(Long counselId);

    List<CounselDTO.Response> getlist();

    CounselDTO.Response update(Long counselId, CounselDTO.Request request);

}
