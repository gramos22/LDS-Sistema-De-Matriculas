package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.ProfessorDTO;
import com.lds.sistema_de_matriculas.domain.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    Professor toProfessor(ProfessorDTO professorDTO);

    void updateProfessorFromDTO(ProfessorDTO professorDTO, @MappingTarget Professor professor);
}