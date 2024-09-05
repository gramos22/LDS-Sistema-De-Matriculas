package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.CurriculumDTO;
import com.lds.sistema_de_matriculas.domain.model.Curriculum;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CurriculumMapper {

    Curriculum toCurriculum(CurriculumDTO curriculumDTO);

    void updateCurriculumFromDTO(CurriculumDTO curriculumDTO, @MappingTarget Curriculum curriculum);
}