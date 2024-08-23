package com.lds.sistema_de_matriculas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CourseTypeEnum {
    
    BACHELORS("BACHELORS"),
    MASTER("MASTER"),
    DOCTORATE("DOCTORATE"),
    VIRTUAL("VIRTUAL");

    private final String type;
}
