package com.lds.sistema_de_matriculas.domain.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.lds.sistema_de_matriculas.domain.enums.CourseTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    private String id;

    private String name;
    private CourseTypeEnum type;

    @DBRef
    private Secretary secretary;

    @DBRef
    private List<Curriculum> curriculums;

    @DBRef
    private List<Student> students;
}