package com.lds.sistema_de_matriculas.domain.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Curriculum {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "curriculum_id")
    private Long id;

    @Column(nullable = false)
    private Double semester; 

    @Column(name = "registration_limit", nullable = false)
    private Date registrationLimit;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Subject> subjects;

    public boolean addSubject(Subject subject) {
        return subjects.add(subject);
    }

}
