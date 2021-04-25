package com.gitprofiles.client;

import com.gitprofiles.exception.ForbiddenException;
import com.gitprofiles.exception.UnexpectedException;
import com.gitprofiles.exception.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientResponseErrorHandlerTest {

    @Mock
    private ClientHttpResponse clientHttpResponse;

    private ClientResponseErrorHandler clientResponseErrorHandler;

    @Before
    public void setUp() {
        clientResponseErrorHandler = new ClientResponseErrorHandler();
    }

    @Test
    public void hasErrorForClientError() throws IOException {
        when(clientHttpResponse.getStatusCode()).thenReturn(NOT_FOUND);
        assertTrue(clientResponseErrorHandler.hasError(clientHttpResponse));
    }

    @Test
    public void hasErrorForServerError() throws IOException {
        when(clientHttpResponse.getStatusCode()).thenReturn(INTERNAL_SERVER_ERROR);
        assertTrue(clientResponseErrorHandler.hasError(clientHttpResponse));
    }

    @Test
    public void hasNoErrorFor200() throws IOException {
        when(clientHttpResponse.getStatusCode()).thenReturn(OK);
        assertFalse(clientResponseErrorHandler.hasError(clientHttpResponse));
    }

    @Test(expected = UserNotFoundException.class)
    public void handleErrorShouldThrowUserNotFoundException() throws IOException {
        when(clientHttpResponse.getStatusCode()).thenReturn(NOT_FOUND);
        clientResponseErrorHandler.handleError(clientHttpResponse);
    }

    @Test(expected = ForbiddenException.class)
    public void handleErrorShouldThrowForbiddenException() throws IOException {
        when(clientHttpResponse.getStatusCode()).thenReturn(FORBIDDEN);
        clientResponseErrorHandler.handleError(clientHttpResponse);
    }

    @Test(expected = UnexpectedException.class)
    public void handleErrorShouldThrowUnexpectedException() throws IOException {
        when(clientHttpResponse.getStatusCode()).thenReturn(BAD_REQUEST);
        clientResponseErrorHandler.handleError(clientHttpResponse);
    }
}
