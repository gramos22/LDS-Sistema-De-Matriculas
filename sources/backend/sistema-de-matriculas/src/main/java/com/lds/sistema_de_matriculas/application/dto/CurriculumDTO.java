package com.lds.sistema_de_matriculas.application.dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumDTO {

    private Double semesterNumber;
    private Date registrationLimit;
    private boolean active;
    private String courseId;
    private List<String> subjectIds;
}