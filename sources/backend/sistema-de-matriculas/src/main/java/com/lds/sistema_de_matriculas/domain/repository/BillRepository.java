package com.lds.sistema_de_matriculas.domain.repository;

import com.lds.sistema_de_matriculas.domain.model.Bill;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BillRepository extends MongoRepository<Bill, String> {

    Optional<Bill> findById(String id);

    @Query("{ 'student.$id' : ?0 }")
    Iterable<Bill> findByStudentId(String studentId);

}
