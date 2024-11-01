package org.BdB.lab.application.mapper;


import org.BdB.lab.application.dto.in.ClientRequest;
import org.BdB.lab.application.dto.out.ClientResponse;
import org.BdB.lab.domain.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClientMapper {

    Client toClient(ClientRequest clientRequest);

    ClientResponse toClientResponse(Client client);
}
