package com.zs.zuoye.config;

public class ApiResultFactory {

    public static <T> ApiResult<T> getSuccessResult() {
        return new ApiResult(true, "", null);
    }

    public static <T> ApiResult<T> getSuccessResult(T data) {
        return new ApiResult(true, "", data);
    }

    public static <T> ApiResult<T> getFailResult(String message) {
        return new ApiResult(false, message, null);
    }
}
