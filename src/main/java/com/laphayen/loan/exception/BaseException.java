package com.laphayen.loan.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseException {

    private String code="";
    private String description="";
    private String message="";

    public BaseException(ResultType resultType) {

        this.code = resultType.getCode();
        this.description = resultType.getDescription();

    }

    public BaseException(ResultType resultType, String message) {

        this.code = resultType.getCode();
        this.description = resultType.getDescription();
        this.message = message;

    }

}
