package com.laphayen.loan.service;

import com.laphayen.loan.domain.Counsel;
import com.laphayen.loan.dto.CounselDTO;
import com.laphayen.loan.exception.BaseException;
import com.laphayen.loan.exception.ResultType;
import com.laphayen.loan.repository.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService {

    private final CounselRepository counselRepository;

    private final ModelMapper modelMapper;

    @Override
    public CounselDTO.Response create(CounselDTO.Request request) {
        Counsel counsel = modelMapper.map(request, Counsel.class);
        counsel.setAppliedAt(LocalDateTime.now());

        Counsel created = counselRepository.save(counsel);

        return modelMapper.map(created, CounselDTO.Response.class);
    }

    @Override
    public CounselDTO.Response get(Long counselId) {
        Counsel counsel = counselRepository.findById(counselId)
                .orElseThrow(() -> new BaseException(ResultType.SYS_ERROR));

        return modelMapper.map(counsel, CounselDTO.Response.class);
    }

    @Override
    public List<CounselDTO.Response> getlist() {
        return counselRepository.findAll().stream()
                .map(counsel -> modelMapper.map(counsel, CounselDTO.Response.class))
                .toList();
    }

    @Override
    public CounselDTO.Response update(Long counselId, CounselDTO.Request request) {
        Counsel counsel = counselRepository.findById(counselId)
                .orElseThrow(() -> new BaseException(ResultType.SYS_ERROR));

        counsel.setName(request.getName());
        counsel.setCellPhone(request.getCellPhone());
        counsel.setEmail(request.getEmail());
        counsel.setMemo(request.getMemo());
        counsel.setAddress(request.getAddress());
        counsel.setAddressDetail(request.getAddressDetail());
        counsel.setZipCode(request.getZipCode());

        counselRepository.save(counsel);

        return modelMapper.map(counsel, CounselDTO.Response.class);
    }

    @Override
    public void delete(Long counselId) {
        Counsel counsel = counselRepository.findById(counselId)
                .orElseThrow(() -> new BaseException(ResultType.SYS_ERROR));

        counsel.setIsDeleted(true);
        counselRepository.save(counsel);

    }


}
