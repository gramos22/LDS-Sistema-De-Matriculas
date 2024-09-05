package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.AddressDTO;
import com.lds.sistema_de_matriculas.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressDTO addressDTO);

    void updateAddressFromDTO(AddressDTO addressDTO, @MappingTarget Address address);
}