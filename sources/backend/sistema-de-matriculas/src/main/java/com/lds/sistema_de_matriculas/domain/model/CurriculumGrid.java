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

@Document("curriculum_grids")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumGrid {

    @Id
    private String id;

    private Date lastUpdate;
    private boolean deferred;
    private boolean completed;

    @DBRef
    private Student student;

    @DBRef
    private List<Subject> subjects;
}