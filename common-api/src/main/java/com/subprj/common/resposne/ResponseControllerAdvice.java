package com.subprj.common.resposne;

import com.subprj.common.resposne.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResponseControllerAdvice {

    /**
     * http status 200 and result fail
     * 비지니스 로직 처리 이슈
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BaseException.class)
    public CommonResponse<String> onBaseException(BaseException e) {
        return CommonResponse.fail(e.getErrorCode());
    }

    /**
     * input valid exception
     * status 400 and result fail
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<String> onArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        if (fieldError != null) {
            return CommonResponse.fail(ErrorCode.COMMON_REQUIRED_VALUE, fieldError.getField());
        } else {
            return CommonResponse.fail(ErrorCode.COMMON_REQUIRED_VALUE, "UNKNOWN");
        }
    }

    /**
     * http status 500 and result fail
     * 시스템 예외
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> onException(Exception e) {
        return CommonResponse.fail(ErrorCode.COMMON_SYSTEM_ERROR);
    }
}
