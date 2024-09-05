package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.BillDTO;
import com.lds.sistema_de_matriculas.domain.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill toBill(BillDTO billDTO);

    void updateBillFromDTO(BillDTO billDTO, @MappingTarget Bill bill);
}