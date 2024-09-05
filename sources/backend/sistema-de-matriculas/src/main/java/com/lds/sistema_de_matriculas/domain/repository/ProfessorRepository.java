package com.lds.sistema_de_matriculas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Professor;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String>{

    Optional<Professor> findById(String professorId);

    List<Professor> findAll();

    @Transactional
    void deleteById(String id);

}
