package com.lds.sistema_de_matriculas.domain.model;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("curriculums")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curriculum {

    @Id
    private String id;

    private Double semesterNumber;
    private Date registrationLimit;
    private boolean active;

    @DBRef
    private Course course;

    @DBRef
    private List<Subject> subjects;
}