package com.lds.sistema_de_matriculas.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Course;

import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends MongoRepository<Course, String>{

    Optional<Course> findById(String id);
    
    List<Course> findAll();

    @Transactional
    void deleteById(String id);
    
}
