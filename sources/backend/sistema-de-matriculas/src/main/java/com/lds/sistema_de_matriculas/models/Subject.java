package com.lds.sistema_de_matriculas.models;

import java.util.Set;

import com.lds.sistema_de_matriculas.enums.SubjectStatusEnum;
import com.lds.sistema_de_matriculas.enums.SubjectTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double credit;

    @Column(nullable = false)
    private String schedule;

    @Enumerated(EnumType.STRING)
    private SubjectTypeEnum type;

    @Enumerated(EnumType.STRING)
    private SubjectStatusEnum status;

    @Column(nullable = false)
    private Double prince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(mappedBy = "subjects")
    private Set<CurriculumGrid> curriculumGrids;

}
