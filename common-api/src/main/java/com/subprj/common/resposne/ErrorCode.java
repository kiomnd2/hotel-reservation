package com.subprj.common.resposne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_NOTFOUND_VALUE("%s 를 찾을 수 없습니다."),
    COMMON_REQUIRED_VALUE("%s 는 필수 값입니다");

    private final String message;
    public String getMessage(Object ...args) {
        return String.format(message, args);
    }
}
