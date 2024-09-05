package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.StudentDTO;
import com.lds.sistema_de_matriculas.domain.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(StudentDTO studentDTO);

    void updateStudentFromDTO(StudentDTO studentDTO, @MappingTarget Student student);
}