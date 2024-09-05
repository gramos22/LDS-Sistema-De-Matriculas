package com.lds.sistema_de_matriculas.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lds.sistema_de_matriculas.domain.model.Paycheck;

import java.util.Optional;


@Repository
public interface PaycheckRepository extends MongoRepository<Paycheck, String>{

    Optional<Paycheck> findById(String id);

    @Query("{ 'professor.$id' : ?0 }")
    Iterable<Paycheck> findByProfessorId(String professorId);

}
