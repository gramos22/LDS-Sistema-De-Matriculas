package com.lds.sistema_de_matriculas.application.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillDTO {

    private Double price;
    private Date dueDate;
    private boolean isPaid;
    private String studentId;
}