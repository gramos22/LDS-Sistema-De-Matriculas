package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.domain.model.Paycheck;
import com.lds.sistema_de_matriculas.domain.service.PaycheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paychecks")
public class PaycheckController {

    private final PaycheckService paycheckService;

    public PaycheckController(PaycheckService paycheckService) {
        this.paycheckService = paycheckService;
    }

    @PostMapping("/professors/{professorId}")
    public ResponseEntity<Paycheck> createPaycheckForProfessor(@PathVariable String professorId) {
        Paycheck paycheck = paycheckService.createPaycheckForProfessor(professorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(paycheck);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paycheck> getPaycheckById(@PathVariable String id) {
        Paycheck paycheck = paycheckService.getPaycheckById(id);
        return ResponseEntity.ok(paycheck);
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<Paycheck> payPaycheck(@PathVariable String id) {
        Paycheck paycheck = paycheckService.payPaycheck(id);
        return ResponseEntity.ok(paycheck);
    }

    @GetMapping("/professors/{professorId}")
    public ResponseEntity<Iterable<Paycheck>> getPaychecksByProfessorId(@PathVariable String professorId) {
        Iterable<Paycheck> paychecks = paycheckService.getPaychecksByProfessorId(professorId);
        return ResponseEntity.ok(paychecks);
    }
}