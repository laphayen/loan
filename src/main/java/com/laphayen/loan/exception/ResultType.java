package com.laphayen.loan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultType {

    SUCCESS("000", "success"),
    SYS_ERROR("900", "system error");

    private final String code;
    private final String description;

}
