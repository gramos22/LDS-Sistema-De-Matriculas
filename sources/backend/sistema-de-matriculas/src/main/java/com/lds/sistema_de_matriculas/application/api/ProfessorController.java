package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.application.dto.ProfessorDTO;
import com.lds.sistema_de_matriculas.domain.model.Professor;
import com.lds.sistema_de_matriculas.domain.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@Valid @RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorService.createProfessor(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable String id) {
        Professor professor = professorService.getProfessorById(id);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable String id, @Valid @RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorService.updateProfessor(id, professorDTO);
        return ResponseEntity.ok(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable String id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Professor>> getAllProfessors() {
        Iterable<Professor> professors = professorService.getAllProfessors();
        return ResponseEntity.ok(professors);
    }
}