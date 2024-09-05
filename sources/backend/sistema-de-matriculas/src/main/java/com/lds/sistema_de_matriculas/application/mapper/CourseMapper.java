package com.lds.sistema_de_matriculas.application.mapper;

import com.lds.sistema_de_matriculas.application.dto.CourseDTO;
import com.lds.sistema_de_matriculas.domain.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toCourse(CourseDTO courseDTO);

    void updateCourseFromDTO(CourseDTO courseDTO, @MappingTarget Course course);
}