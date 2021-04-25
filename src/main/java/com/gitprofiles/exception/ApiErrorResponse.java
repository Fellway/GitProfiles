package com.gitprofiles.exception;

import lombok.Getter;

@Getter
public class ApiErrorResponse {
    private Integer statusCode;
    private String message;
    private Integer errorCode;

    public ApiErrorResponse(final Integer statusCode, final String message, final Integer errorCode) {
        this.statusCode = statusCode;
        this.message = message;
        this.errorCode = errorCode;
    }
}
