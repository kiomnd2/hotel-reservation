package com.subprj.hotel.common.response.exception;

import com.subprj.common.resposne.ErrorCode;
import com.subprj.common.resposne.exception.BaseException;

public class NotFoundHotelException extends BaseException {
    public NotFoundHotelException() {
        super(ErrorCode.COMMON_NOTFOUND_VALUE, "hotel");
    }
}
