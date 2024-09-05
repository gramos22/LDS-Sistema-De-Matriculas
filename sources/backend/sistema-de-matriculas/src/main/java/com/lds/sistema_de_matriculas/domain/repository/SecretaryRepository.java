package com.lds.sistema_de_matriculas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Secretary;

public interface SecretaryRepository extends MongoRepository<Secretary, String>{

    Optional<Secretary> findById(String secretaryId);

    List<Secretary> findAll();

    @Transactional
    void deleteById(String id);
    
}
