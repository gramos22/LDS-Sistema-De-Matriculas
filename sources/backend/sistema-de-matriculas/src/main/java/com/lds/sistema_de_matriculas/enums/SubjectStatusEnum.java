package com.lds.sistema_de_matriculas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubjectStatusEnum {

    OPEN("OPEN"),
    CLOSED("CLOSED"),
    CANCELLED("CANCELLED");

    private final String status;
}
