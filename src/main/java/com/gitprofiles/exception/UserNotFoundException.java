package com.gitprofiles.exception;

public class UserNotFoundException extends AbstractNetException {
    public UserNotFoundException(final ApiRestErrors apiError) {
        super(apiError.getMessage(), apiError.getErrorCode());
    }
}
