package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.PaycheckDTO;
import com.lds.sistema_de_matriculas.domain.model.Paycheck;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaycheckMapper {

    Paycheck toPaycheck(PaycheckDTO paycheckDTO);

    void updatePaycheckFromDTO(PaycheckDTO paycheckDTO, @MappingTarget Paycheck paycheck);
}