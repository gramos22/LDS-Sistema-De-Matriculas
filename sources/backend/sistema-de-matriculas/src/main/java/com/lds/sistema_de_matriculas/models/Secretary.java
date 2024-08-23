package com.lds.sistema_de_matriculas.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "secretary")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Secretary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "secretary_id")
    private Long id;

    @Column(nullable = false)
    private String name; 

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Course> courses;
}
