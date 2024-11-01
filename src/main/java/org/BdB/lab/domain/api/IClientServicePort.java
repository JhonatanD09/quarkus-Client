package org.BdB.lab.domain.api;

import org.BdB.lab.domain.models.Client;

public interface IClientServicePort {

    Client getClient(char documentType, int documentNumber);

}
