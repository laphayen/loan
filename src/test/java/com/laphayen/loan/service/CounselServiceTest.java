package com.laphayen.loan.service;

import com.laphayen.loan.domain.Counsel;
import com.laphayen.loan.dto.CounselDTO;
import com.laphayen.loan.repository.CounselRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CounselServiceTest {

    @InjectMocks
    CounselServiceImpl counselService;

    @Mock
    private CounselRepository counselRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewCounselEntity_When_RequestCounsel() {
        Counsel entity = Counsel.builder()
                .name("그리디")
                .cellPhone("010-1234-5678")
                .email("github@gmail.com")
                .memo("신용대출 상담을 신청합니다.")
                .zipCode("00000")
                .address("대전광역시 유성구 덕명동")
                .addressDetail("589-4")
                .build();

        CounselDTO.Request request = CounselDTO.Request.builder()
                .name("그리디")
                .cellPhone("010-1234-5678")
                .email("github@gmail.com")
                .memo("신용대출 상담을 신청합니다.")
                .zipCode("00000")
                .address("대전광역시 유성구 덕명동")
                .addressDetail("589-4")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);

        CounselDTO.Response actual = counselService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());

    }

}