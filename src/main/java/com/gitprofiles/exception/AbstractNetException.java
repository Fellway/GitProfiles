package com.gitprofiles.exception;

import lombok.Getter;

@Getter
public class AbstractNetException extends RuntimeException {

    private final int statusCode;

    public AbstractNetException(final String message, final int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
