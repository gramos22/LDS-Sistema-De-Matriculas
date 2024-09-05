package com.lds.sistema_de_matriculas.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.CurriculumGrid;
import java.util.Optional;


@Repository
public interface CurriculumGridRepository extends MongoRepository<CurriculumGrid, String>{

    Optional<CurriculumGrid> findById(String id);

    @Query("{ 'student.$id' : ?0 }")
    Iterable<CurriculumGrid> findByStudentId(String studentId);

    @Transactional
    void deleteById(String id);

}
