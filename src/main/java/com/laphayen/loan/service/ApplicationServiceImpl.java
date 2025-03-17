package com.laphayen.loan.service;

import com.laphayen.loan.domain.Application;
import com.laphayen.loan.dto.ApplicationDTO;
import com.laphayen.loan.exception.BaseException;
import com.laphayen.loan.exception.ResultType;
import com.laphayen.loan.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final ModelMapper modelMapper;

    @Override
    public ApplicationDTO.Response create(ApplicationDTO.Request request) {
        Application application = modelMapper.map(request, Application.class);
        application.setAppliedAt(LocalDateTime.now());
        application.setCreatedAt(LocalDateTime.now());
        application.setUpdatedAt(LocalDateTime.now());

        Application applied = applicationRepository.save(application);

        return modelMapper.map(applied, ApplicationDTO.Response.class);
    }

    @Override
    public ApplicationDTO.Response get(Long ApplicationId) {
        Application application = applicationRepository.findById(ApplicationId)
                .orElseThrow(() -> new BaseException(ResultType.SYS_ERROR));

        return modelMapper.map(application, ApplicationDTO.Response.class);
    }

    @Override
    public List<ApplicationDTO.Response> getlist() {
        return applicationRepository.findAll().stream()
                .map(application -> modelMapper.map(application, ApplicationDTO.Response.class))
                .toList();
    }

}
