package com.subprj.hotel.common.response.exception;

import com.subprj.common.response.ErrorCode;
import com.subprj.common.response.exception.BaseException;

public class NotFoundHotelException extends BaseException {
    public NotFoundHotelException() {
        super(ErrorCode.COMMON_NOTFOUND_VALUE, "hotel");
    }
}
