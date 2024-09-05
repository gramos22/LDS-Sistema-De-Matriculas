package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.CurriculumGridDTO;
import com.lds.sistema_de_matriculas.domain.model.CurriculumGrid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CurriculumGridMapper {

    CurriculumGrid toCurriculumGrid(CurriculumGridDTO curriculumGridDTO);

    void updateCurriculumGridFromDTO(CurriculumGridDTO curriculumGridDTO, @MappingTarget CurriculumGrid curriculumGrid);
}