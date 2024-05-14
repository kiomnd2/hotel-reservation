package com.subprj.common.response.exception;

import com.subprj.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ErrorCode errorCode;
    public BaseException(ErrorCode errorCode, Object ... args) {
        super(errorCode.getMessage(args));
        this.errorCode = errorCode;
    }
}
