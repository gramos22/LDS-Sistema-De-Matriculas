package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.application.dto.CurriculumDTO;
import com.lds.sistema_de_matriculas.domain.model.Curriculum;
import com.lds.sistema_de_matriculas.domain.service.CurriculumService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curriculums")
public class CurriculumController {

    private final CurriculumService curriculumService;

    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    @PostMapping("/courses/{courseId}")
    public ResponseEntity<Curriculum> createCurriculum(@PathVariable String courseId, @Valid @RequestBody CurriculumDTO curriculumDTO) {
        Curriculum curriculum = curriculumService.createCurriculum(courseId, curriculumDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculum);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getCurriculumById(@PathVariable String id) {
        Curriculum curriculum = curriculumService.getCurriculumById(id);
        return ResponseEntity.ok(curriculum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> updateCurriculum(@PathVariable String id, @Valid @RequestBody CurriculumDTO curriculumDTO) {
        Curriculum curriculum = curriculumService.updateCurriculum(id, curriculumDTO);
        return ResponseEntity.ok(curriculum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable String id) {
        curriculumService.deleteCurriculum(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Iterable<Curriculum>> getCurriculumsByCourseId(@PathVariable String courseId) {
        Iterable<Curriculum> curriculums = curriculumService.getCurriculumsByCourseId(courseId);
        return ResponseEntity.ok(curriculums);
    }
}