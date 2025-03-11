package com.laphayen.loan.dto;

import com.laphayen.loan.exception.BaseException;
import com.laphayen.loan.exception.ResultType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultObject implements Serializable {

    public String code;
    public String description;

    public ResultObject(ResultType resultType) {
        this.code = resultType.getCode();
        this.description = resultType.getDescription();

    }

    public ResultObject(ResultType resultType, String message) {
        this.code = resultType.getCode();
        this.description = message;

    }

    public ResultObject(BaseException e) {
        this.code = e.getCode();
        this.description = e.getDescription();

    }

    public static ResultObject getSuccess() {
        return new ResultObject(ResultType.SUCCESS);
    }

}
