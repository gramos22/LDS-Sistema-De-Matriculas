package com.lds.sistema_de_matriculas.application.dto;

import com.lds.sistema_de_matriculas.domain.enums.SubjectStatusEnum;
import com.lds.sistema_de_matriculas.domain.enums.SubjectTypeEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private Double credit;
    private String schedule;
    private SubjectTypeEnum type;
    private SubjectStatusEnum status;
    private Double price;
    private String curriculumId;
    private String professorId;
}