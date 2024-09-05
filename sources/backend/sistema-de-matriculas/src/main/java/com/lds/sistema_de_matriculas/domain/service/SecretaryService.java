package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.SecretaryDTO;
import com.lds.sistema_de_matriculas.application.mapper.SecretaryMapper;
import com.lds.sistema_de_matriculas.domain.model.Secretary;
import com.lds.sistema_de_matriculas.domain.repository.SecretaryRepository;
import org.springframework.stereotype.Service;

@Service
public class SecretaryService {

    private final SecretaryRepository secretaryRepository;
    private final SecretaryMapper secretaryMapper;

    public SecretaryService(SecretaryRepository secretaryRepository, SecretaryMapper secretaryMapper) {
        this.secretaryRepository = secretaryRepository;
        this.secretaryMapper = secretaryMapper;
    }

    public Secretary createSecretary(SecretaryDTO secretaryDTO) {
        Secretary secretary = secretaryMapper.toSecretary(secretaryDTO);
        return secretaryRepository.save(secretary);
    }

    public Secretary getSecretaryById(String id) {
        return secretaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Secretary not found with ID: " + id));
    }

    public Secretary updateSecretary(String id, SecretaryDTO secretaryDTO) {
        Secretary existingSecretary = getSecretaryById(id);
        secretaryMapper.updateSecretaryFromDTO(secretaryDTO, existingSecretary);
        return secretaryRepository.save(existingSecretary);
    }

    public void deleteSecretary(String id) {
        secretaryRepository.deleteById(id);
    }

    public Iterable<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }
}