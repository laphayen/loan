package com.laphayen.loan.service;

import com.laphayen.loan.dto.ApplicationDTO;

public interface ApplicationService {

    ApplicationDTO.Response create(ApplicationDTO.Request request);


}
