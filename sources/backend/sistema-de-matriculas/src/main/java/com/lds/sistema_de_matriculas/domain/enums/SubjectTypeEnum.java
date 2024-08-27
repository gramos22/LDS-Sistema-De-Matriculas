package com.lds.sistema_de_matriculas.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubjectTypeEnum {
    
    OPTIONAL("OPTIONAL"),
    MANDATORY("MANDATORY");

    private final String type; 

}
