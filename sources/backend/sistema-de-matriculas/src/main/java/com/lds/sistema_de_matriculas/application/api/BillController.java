package com.lds.sistema_de_matriculas.application.api;

import com.lds.sistema_de_matriculas.domain.model.Bill;
import com.lds.sistema_de_matriculas.domain.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/students/{studentId}")
    public ResponseEntity<Bill> createBillForStudent(@PathVariable String studentId) {
        Bill bill = billService.createBillForStudent(studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(bill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable String id) {
        Bill bill = billService.getBillById(id);
        return ResponseEntity.ok(bill);
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<Bill> payBill(@PathVariable String id) {
        Bill bill = billService.payBill(id);
        return ResponseEntity.ok(bill);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Iterable<Bill>> getBillsByStudentId(@PathVariable String studentId) {
        Iterable<Bill> bills = billService.getBillsByStudentId(studentId);
        return ResponseEntity.ok(bills);
    }
}