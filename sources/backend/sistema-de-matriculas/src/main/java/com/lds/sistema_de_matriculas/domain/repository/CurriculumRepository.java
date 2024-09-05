package com.lds.sistema_de_matriculas.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Curriculum;
import java.util.Optional;


@Repository
public interface CurriculumRepository extends MongoRepository<Curriculum, String>{

    Optional<Curriculum> findById(String id);

    @Query("{ 'course.$id' : ?0 }")
    Iterable<Curriculum> findByCourseId(String courseId);

    @Transactional
    void deleteById(String id);

}
