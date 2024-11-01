package org.BdB.lab.domain.spi;


import org.BdB.lab.domain.models.Client;

public interface IClientPersistencePort {

    Client getClient(char documentType, int documentNumber);

}
