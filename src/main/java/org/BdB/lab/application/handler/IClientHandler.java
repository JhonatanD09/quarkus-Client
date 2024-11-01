package org.BdB.lab.application.handler;


import org.BdB.lab.application.dto.out.ClientResponse;

public interface IClientHandler {

     ClientResponse getClient(char documentType, int documentNumber);
}
