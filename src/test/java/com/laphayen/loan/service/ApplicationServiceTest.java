package com.laphayen.loan.service;

import com.laphayen.loan.domain.Application;
import com.laphayen.loan.dto.ApplicationDTO;
import com.laphayen.loan.repository.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @InjectMocks
    ApplicationServiceImpl applicationService;

    @Mock
    private ApplicationRepository applicationRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewApplyEntity_When_RequestApply() {
        Application entity = Application.builder()
                .name("그리디")
                .cellPhone("010-1234-5678")
                .email("github@gmail.com")
                .hopeAmount(BigDecimal.valueOf(12000000))
                .build();

        ApplicationDTO.Request request = ApplicationDTO.Request.builder()
                .name("그리디")
                .cellPhone("010-1234-5678")
                .email("github@gmail.com")
                .hopeAmount(BigDecimal.valueOf(12000000))
                .build();

        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);

        ApplicationDTO.Response actual = applicationService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
    }

}
