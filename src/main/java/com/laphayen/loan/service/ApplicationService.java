package com.laphayen.loan.service;

import com.laphayen.loan.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

    ApplicationDTO.Response create(ApplicationDTO.Request request);

    ApplicationDTO.Response get(Long ApplicationId);

    List<ApplicationDTO.Response> getlist();


}
