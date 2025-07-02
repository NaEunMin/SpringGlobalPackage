package com.hansung.likelion.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hansung.likelion.global.response.code.BaseResponseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonPropertyOrder({"isSuccess", "timestamp", "code", "httpStatus", "message", "data"})
public class ErrorResponse<T> extends BaseResponse{
    private final int httpStatus;
    private final T data; //data에 어떤 타입이 올지 몰라 제네릭으로 선언

    @Builder
    public ErrorResponse(T data, BaseResponseCode baseResponseCode){
        super(false, baseResponseCode.getCode(), baseResponseCode.getMessage());
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    @Builder
    public ErrorResponse(T data, BaseResponseCode baseResponseCode, String message){
        super(false, baseResponseCode.getCode(), message);
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    //매개변수 하나는 from 네이밍
    //매개변수 여러 개는 of 네이밍
    //데이터가 없는 BaseResponseCode 사용
    public static ErrorResponse<?> from(BaseResponseCode baseResponseCode){
        return new ErrorResponse<>(null, baseResponseCode);
    }

    //데이터가 없지만 message를 커스텀해서 사용
    public static ErrorResponse<?> of(BaseResponseCode baseResponseCode, String message){
        return new ErrorResponse<>(null, baseResponseCode, message);
    }

    //데이터가 있는 경우
    public static <T> ErrorResponse<T> of(T data ,BaseResponseCode baseResponseCode){
        return new ErrorResponse<>(data,baseResponseCode);
    }

    //데이터가 있고 message를 커스텀하는 경우
    public static <T> ErrorResponse<T> of(T data, BaseResponseCode baseResponseCode, String message){
        return new ErrorResponse<>(data, baseResponseCode, message);
    }
}
