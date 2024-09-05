package com.lds.sistema_de_matriculas.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lds.sistema_de_matriculas.domain.model.Address;

import java.util.Optional;


@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

    Optional<Address> findById(String id);

    @Transactional
    void deleteById(String id);

}
