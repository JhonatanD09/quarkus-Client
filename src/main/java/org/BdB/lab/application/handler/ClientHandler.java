package org.BdB.lab.application.handler;



import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.BdB.lab.application.dto.out.ClientResponse;
import org.BdB.lab.application.mapper.IClientMapper;
import org.BdB.lab.application.utils.Validators;
import org.BdB.lab.domain.api.IClientServicePort;
import org.BdB.lab.infraestructure.exceptions.InvalidDocumentTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ApplicationScoped
@RequiredArgsConstructor
public class ClientHandler implements IClientHandler {

    private final IClientServicePort iClientServicePort;
    private  final IClientMapper iClientMapper;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public ClientResponse getClient(char documentType, int documentNumber) {
        if(Validators.valideTypeDocument(documentType)){
            LOGGER.info("Tipo de documento ok, se envia a consultar datos del cliente desde : " + getClass());
            return iClientMapper.toClientResponse(iClientServicePort.getClient(documentType,documentNumber));
        }else {
            LOGGER.error("Tipo de documento no coincide con C o P");
            throw  new InvalidDocumentTypeException();
        }
    }
}
