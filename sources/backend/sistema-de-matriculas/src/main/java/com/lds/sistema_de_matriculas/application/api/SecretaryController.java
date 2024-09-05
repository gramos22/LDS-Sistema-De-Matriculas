package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.application.dto.SecretaryDTO;
import com.lds.sistema_de_matriculas.domain.model.Secretary;
import com.lds.sistema_de_matriculas.domain.service.SecretaryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secretaries")
public class SecretaryController {

    private final SecretaryService secretaryService;

    public SecretaryController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }

    @PostMapping
    public ResponseEntity<Secretary> createSecretary(@Valid @RequestBody SecretaryDTO secretaryDTO) {
        Secretary secretary = secretaryService.createSecretary(secretaryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(secretary);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secretary> getSecretaryById(@PathVariable String id) {
        Secretary secretary = secretaryService.getSecretaryById(id);
        return ResponseEntity.ok(secretary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Secretary> updateSecretary(@PathVariable String id, @Valid @RequestBody SecretaryDTO secretaryDTO) {
        Secretary secretary = secretaryService.updateSecretary(id, secretaryDTO);
        return ResponseEntity.ok(secretary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecretary(@PathVariable String id) {
        secretaryService.deleteSecretary(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Secretary>> getAllSecretaries() {
        Iterable<Secretary> secretaries = secretaryService.getAllSecretaries();
        return ResponseEntity.ok(secretaries);
    }
}