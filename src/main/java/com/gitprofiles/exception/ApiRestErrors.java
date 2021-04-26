package com.gitprofiles.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
public enum ApiRestErrors {

    USER_NOT_FOUND(4000, "User with given login doesn't exist", NOT_FOUND),
    PRIVATE_ACCOUNT(4001, "You are not able to see this profile", FORBIDDEN),
    PAGE_NOT_FOUND(4002, "Sorry, we couldn't find the page you were looking for.", NOT_FOUND),
    UNEXPECTED_ERROR(5000, "Unexpected server error", INTERNAL_SERVER_ERROR);

    private final Integer errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    ApiRestErrors(final Integer errorCode, final String message, final HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
