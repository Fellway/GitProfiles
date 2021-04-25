package com.gitprofiles.exception;

public class UnexpectedException extends AbstractNetException {
    public UnexpectedException(final ApiRestErrors apiError) {
        super(apiError.getMessage(), apiError.getErrorCode());
    }
}
