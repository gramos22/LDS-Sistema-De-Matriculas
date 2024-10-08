package com.lds.sistema_de_matriculas.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumGridDTO {

    private Date lastUpdate;
    private boolean deferred;
    private boolean completed;
    private String studentId;
    private List<String> subjectIds;
}