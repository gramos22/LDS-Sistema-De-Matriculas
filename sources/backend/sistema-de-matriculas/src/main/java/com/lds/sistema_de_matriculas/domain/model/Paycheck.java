package com.lds.sistema_de_matriculas.domain.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("paychecks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paycheck {

    @Id
    private String id;

    private Double value;
    private Date paymentDate;
    private boolean isPaid;

    @DBRef
    private Professor professor;
}