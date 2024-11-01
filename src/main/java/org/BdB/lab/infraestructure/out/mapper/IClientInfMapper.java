package org.BdB.lab.infraestructure.out.mapper;


import org.BdB.lab.domain.models.Client;
import org.BdB.lab.infraestructure.out.entity.EntityClient;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClientInfMapper {

    @Mapping(target = "documentType", ignore = true)
    @Mapping(target = "documentNumber", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = {"documentType","documentNumber"})
    Client toClient(EntityClient client);

}
