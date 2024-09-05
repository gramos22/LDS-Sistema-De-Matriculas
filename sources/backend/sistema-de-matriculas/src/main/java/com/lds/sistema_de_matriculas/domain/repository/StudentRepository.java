package com.lds.sistema_de_matriculas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

    Optional<Student> findById(String studentId);

    List<Student> findAll();

    @Transactional
    void deleteById(String id);

}
