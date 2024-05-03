package com.subprj.common.resposne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String code;
    private T body;
    private String message;

    public static <T> CommonResponse<T> success(T body) {
        return new CommonResponse<>("SUCCESS", body, "처리되었습니다.");
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode.name(), null, errorCode.getMessage());
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode, Object ...args) {
        return new CommonResponse<>(errorCode.name(), null, errorCode.getMessage(args));
    }
}
