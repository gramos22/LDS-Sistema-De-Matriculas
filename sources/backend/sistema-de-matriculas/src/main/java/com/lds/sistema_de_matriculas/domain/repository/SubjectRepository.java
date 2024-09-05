package com.lds.sistema_de_matriculas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String>{

    Optional<Subject> findById(String id);

    @Query("{ 'curriculum.$id' : ?0 }")
    Iterable<Subject> findByCurriculumId(String curriculumId);

    List<Subject> findAllById(List<String> subjectIds);

    @Transactional
    void deleteById(String id);

}
