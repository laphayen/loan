package com.laphayen.loan.exception;

import com.laphayen.loan.dto.ResponseDTO;
import com.laphayen.loan.dto.ResultObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class APIExceptionHandler extends RuntimeException {

    protected ResponseDTO<ResultObject> handleBaseException(BaseException e, HttpServletRequest request, HttpServletResponse response) {

        log.error(e.getMessage(), e);

        return new ResponseDTO<>();

    }

}
