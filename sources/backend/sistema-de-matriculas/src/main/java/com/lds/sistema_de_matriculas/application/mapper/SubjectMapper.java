package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.SubjectDTO;
import com.lds.sistema_de_matriculas.domain.model.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectDTO subjectDTO);

    void updateSubjectFromDTO(SubjectDTO subjectDTO, @MappingTarget Subject subject);
}