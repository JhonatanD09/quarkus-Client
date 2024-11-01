package org.BdB.lab.infraestructure.exceptionHandler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.BdB.lab.infraestructure.exceptions.UserNotFoundException;

import java.util.Collections;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {


    private static final String MESSAGE = "Message";

    @Override
    public Response toResponse(UserNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()))
                .build();
    }
}
