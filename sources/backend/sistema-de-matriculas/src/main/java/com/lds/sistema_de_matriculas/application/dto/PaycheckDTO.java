package com.lds.sistema_de_matriculas.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaycheckDTO {
    private Double value;
    private Date paymentDate;
    private boolean isPaid;
    private String professorId;
}