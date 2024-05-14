package com.subprj.common;

import com.subprj.common.response.ErrorCode;
import com.subprj.common.response.exception.BaseException;

public class InvalidHotelInfoException extends BaseException {
    public InvalidHotelInfoException(String hotelId, String roomTypeId) {
        super(ErrorCode.COMMON_NOTFOUND_VALUE, hotelId, roomTypeId);
    }
}
