package org.BdB.lab.infraestructure.out.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.BdB.lab.domain.models.Client;
import org.BdB.lab.domain.spi.IClientPersistencePort;
import org.BdB.lab.infraestructure.exceptions.UserNotFoundException;
import org.BdB.lab.infraestructure.out.entity.EntityClient;
import org.BdB.lab.infraestructure.out.mapper.IClientInfMapper;
import org.BdB.lab.infraestructure.out.utils.UserDefault;
import org.BdB.lab.infraestructure.out.utils.Validators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
@ApplicationScoped
public class ClientAdapter implements IClientPersistencePort {

    private final IClientInfMapper iClientInfMapper;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientAdapter.class);

    @Override
    public Client getClient(char documentType, int documentNumber) {
        EntityClient client = UserDefault.client();
        if(Validators.isClientDocumentType(client,documentType) &&
                Validators.isClientDocument(client,documentNumber)){
            LOGGER.info("Consulta del cliente desde la clase " + getClass());
            return iClientInfMapper.toClient(client);
        }else{
            LOGGER.error("El tipo o numero de documento no coinciden con los registros almacenados");
            throw  new UserNotFoundException();
        }
    }
}
