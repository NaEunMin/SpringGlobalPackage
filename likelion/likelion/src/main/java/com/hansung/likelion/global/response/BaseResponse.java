package com.hansung.likelion.global.response;

import com.hansung.likelion.global.response.code.BaseResponseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@RequiredArgsConstructor
public class BaseResponse {
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    //성공여부와 BaseResponseCode를 기반으로 넘겨준다.
    public static BaseResponse of(Boolean isSuccess, BaseResponseCode baseResponseCode) {
        return new BaseResponse(isSuccess, baseResponseCode.getCode(), baseResponseCode.getMessage());
    }

    //성공여부와 BaseResponseCode와 message를 넘겨준다.
    //여기서 message는 커스텀해서 사용하는 듯하다.
    public static BaseResponse of(Boolean isSuccess, BaseResponseCode baseResponseCode, String message ) {
        return new BaseResponse(isSuccess, baseResponseCode.getCode(), message);
    }

    //성공여부와 code, message를 넘겨준다.
    //code, message는 커스텀해서 사용한다.
    public static BaseResponse of(Boolean isSuccess, String code, String message) {
        return new BaseResponse(isSuccess, code, message);
    }
}
