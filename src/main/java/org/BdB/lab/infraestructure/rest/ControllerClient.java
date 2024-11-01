package org.BdB.lab.infraestructure.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import lombok.RequiredArgsConstructor;
import org.BdB.lab.application.handler.IClientHandler;
import org.BdB.lab.infraestructure.exceptions.InvalidDocumentTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
@Path("/api/client")
public class ControllerClient {

    private final IClientHandler iClientHandler;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ControllerClient.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient(@QueryParam("documentType") String documentType,
                                              @QueryParam("documentNumber") int documentNumber){
        if(documentType.isEmpty()){
            LOGGER.error("Tipo de documento vacio");
            throw  new InvalidDocumentTypeException();
        }else {
            LOGGER.info("Ejecutando desde "+ getClass() + " con info : Tipo de documento:" +documentType +
                    "numero de documento: " + documentNumber);
            return Response.ok(iClientHandler.getClient(documentType.charAt(0), documentNumber)).build();
        }
    }
}
