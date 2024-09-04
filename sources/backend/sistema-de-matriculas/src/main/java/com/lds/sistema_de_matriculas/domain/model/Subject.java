package com.lds.sistema_de_matriculas.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.lds.sistema_de_matriculas.domain.enums.SubjectStatusEnum;
import com.lds.sistema_de_matriculas.domain.enums.SubjectTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("subjects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {

    @Id
    private String id;

    private String name;
    private Double credit;
    private String schedule;
    private SubjectTypeEnum type;
    private SubjectStatusEnum status;
    private Double price;

    @DBRef
    private Curriculum curriculum;

    @DBRef
    private Professor professor;
}