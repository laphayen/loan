package com.laphayen.loan.controller;

import com.laphayen.loan.dto.ResponseDTO;
import com.laphayen.loan.dto.ResultObject;

public abstract class AbstractController {

    protected <T> ResponseDTO<T> ok() {
        return ok(null, ResultObject.getSuccess());

    }

    protected <T> ResponseDTO<T> ok(T data) {
        return ok(data, ResultObject.getSuccess());

    }

    protected <T> ResponseDTO<T> ok(T data, ResultObject result) {
        ResponseDTO<T> obj = new ResponseDTO<>();
        obj.setResult(result);
        obj.setData(data);

        return obj;
    }

}
