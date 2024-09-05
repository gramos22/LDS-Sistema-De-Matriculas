package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.application.dto.SubjectDTO;
import com.lds.sistema_de_matriculas.domain.model.Subject;
import com.lds.sistema_de_matriculas.domain.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/curriculums/{curriculumId}")
    public ResponseEntity<Subject> createSubject(@PathVariable String curriculumId, @Valid @RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectService.createSubject(curriculumId, subjectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(subject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable String id) {
        Subject subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String id, @Valid @RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectService.updateSubject(id, subjectDTO);
        return ResponseEntity.ok(subject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/curriculums/{curriculumId}")
    public ResponseEntity<Iterable<Subject>> getSubjectsByCurriculumId(@PathVariable String curriculumId) {
        Iterable<Subject> subjects = subjectService.getSubjectsByCurriculumId(curriculumId);
        return ResponseEntity.ok(subjects);
    }
}