package org.BdB.lab.infraestructure.exceptionHandler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.BdB.lab.infraestructure.exceptions.InvalidDocumentTypeException;

import java.util.Collections;

@Provider
public class InvalidDocumentTypeExceptionMapper implements ExceptionMapper<InvalidDocumentTypeException> {


    private static final String MESSAGE = "Message";

    @Override
    public Response toResponse(InvalidDocumentTypeException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Collections.singletonMap(MESSAGE, ExceptionResponse.DOCUMENT_TYPE_NOT_FOUND.getMessage()))
                .build();
    }

}
