package com.lds.sistema_de_matriculas.application.dto;

import com.lds.sistema_de_matriculas.domain.enums.CourseTypeEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private CourseTypeEnum type;

    private String secretaryId;
}