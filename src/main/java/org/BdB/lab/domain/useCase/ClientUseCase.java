package org.BdB.lab.domain.useCase;


import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.BdB.lab.domain.api.IClientServicePort;
import org.BdB.lab.domain.models.Client;
import org.BdB.lab.domain.spi.IClientPersistencePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
@ApplicationScoped
public class ClientUseCase implements IClientServicePort {

    private final IClientPersistencePort iClientPersistencePort;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientUseCase.class);

    @Override
    public Client getClient(char documentType, int documentNumber) {
        LOGGER.info("Llega a la capa de dominio y consulta en la capa de persistencia");
        return iClientPersistencePort.getClient(documentType,documentNumber);
    }
}
