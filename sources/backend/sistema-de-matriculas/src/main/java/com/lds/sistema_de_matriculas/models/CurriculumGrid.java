package com.lds.sistema_de_matriculas.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "curriculum")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumGrid {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "curriculum_grid_id")
    private Long id;

    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

    @Column(name = "deferred")
    private boolean deferred = false;

    @Column(name = "completed")
    private boolean completed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_id")
    private Student student;

    @ManyToMany
    @JoinTable(
        name = "curriculumgrid_subject",
        joinColumns = @JoinColumn(name = "curriculum_grid_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

}
