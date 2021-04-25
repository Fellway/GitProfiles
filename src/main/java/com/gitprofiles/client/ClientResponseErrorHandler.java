package com.gitprofiles.client;

import com.gitprofiles.exception.ForbiddenException;
import com.gitprofiles.exception.UnexpectedException;
import com.gitprofiles.exception.UserNotFoundException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static com.gitprofiles.exception.ApiRestErrors.*;
import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class ClientResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(final ClientHttpResponse clientHttpResponse) throws IOException {
        return (clientHttpResponse.getStatusCode().series() == CLIENT_ERROR
                || clientHttpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(final ClientHttpResponse clientHttpResponse) throws IOException {
        switch (clientHttpResponse.getStatusCode()) {
            case NOT_FOUND:
                throw new UserNotFoundException(USER_NOT_FOUND);
            case FORBIDDEN:
                throw new ForbiddenException(PRIVATE_ACCOUNT);
            default:
                throw new UnexpectedException(UNEXPECTED_ERROR);
        }
    }
}
