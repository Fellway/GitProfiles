package com.gitprofiles.exception;

public class ForbiddenException extends AbstractNetException {
    public ForbiddenException(final ApiRestErrors apiError) {
        super(apiError.getMessage(), apiError.getErrorCode());
    }
}
