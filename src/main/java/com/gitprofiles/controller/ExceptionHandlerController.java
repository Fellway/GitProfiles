package com.gitprofiles.controller;

import com.gitprofiles.exception.ApiErrorResponse;
import com.gitprofiles.exception.ForbiddenException;
import com.gitprofiles.exception.UnexpectedException;
import com.gitprofiles.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseBody
    @ResponseStatus(code = NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ApiErrorResponse handleUserNotFoundException(final UserNotFoundException e) {
        return new ApiErrorResponse(NOT_FOUND.value(), e.getMessage(), e.getStatusCode());
    }

    @ResponseBody
    @ResponseStatus(code = FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public ApiErrorResponse handleForbiddenException(final ForbiddenException e) {
        return new ApiErrorResponse(FORBIDDEN.value(), e.getMessage(), e.getStatusCode());
    }

    @ResponseBody
    @ResponseStatus(code = INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnexpectedException.class)
    public ApiErrorResponse handleUnexpectedException(final UnexpectedException e) {
        return new ApiErrorResponse(INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getStatusCode());
    }
}
