package com.subprj.hotel.common.response.exception;

import com.subprj.common.response.ErrorCode;
import com.subprj.common.response.exception.BaseException;

public class NotFoundHotelRoomException extends BaseException {
    public NotFoundHotelRoomException() {
        super(ErrorCode.COMMON_NOTFOUND_VALUE, "hotelRoom");
    }
}
