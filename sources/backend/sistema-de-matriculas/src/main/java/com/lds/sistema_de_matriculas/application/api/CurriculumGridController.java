package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.application.dto.CurriculumGridDTO;
import com.lds.sistema_de_matriculas.domain.model.CurriculumGrid;
import com.lds.sistema_de_matriculas.domain.service.CurriculumGridService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curriculum-grids")
public class CurriculumGridController {

    private final CurriculumGridService curriculumGridService;

    public CurriculumGridController(CurriculumGridService curriculumGridService) {
        this.curriculumGridService = curriculumGridService;
    }

    @PostMapping("/students/{studentId}")
    public ResponseEntity<CurriculumGrid> createCurriculumGrid(@PathVariable String studentId, @Valid @RequestBody CurriculumGridDTO curriculumGridDTO) {
        CurriculumGrid curriculumGrid = curriculumGridService.createCurriculumGrid(studentId, curriculumGridDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculumGrid);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumGrid> getCurriculumGridById(@PathVariable String id) {
        CurriculumGrid curriculumGrid = curriculumGridService.getCurriculumGridById(id);
        return ResponseEntity.ok(curriculumGrid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurriculumGrid> updateCurriculumGrid(@PathVariable String id, @Valid @RequestBody CurriculumGridDTO curriculumGridDTO) {
        CurriculumGrid curriculumGrid = curriculumGridService.updateCurriculumGrid(id, curriculumGridDTO);
        return ResponseEntity.ok(curriculumGrid);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculumGrid(@PathVariable String id) {
        curriculumGridService.deleteCurriculumGrid(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Iterable<CurriculumGrid>> getCurriculumGridsByStudentId(@PathVariable String studentId) {
        Iterable<CurriculumGrid> curriculumGrids = curriculumGridService.getCurriculumGridsByStudentId(studentId);
        return ResponseEntity.ok(curriculumGrids);
    }
}