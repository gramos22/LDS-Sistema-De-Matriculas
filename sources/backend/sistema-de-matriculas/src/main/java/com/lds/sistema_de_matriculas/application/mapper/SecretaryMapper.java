package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.SecretaryDTO;
import com.lds.sistema_de_matriculas.domain.model.Secretary;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SecretaryMapper {

    Secretary toSecretary(SecretaryDTO secretaryDTO);

    void updateSecretaryFromDTO(SecretaryDTO secretaryDTO, @MappingTarget Secretary secretary);
}