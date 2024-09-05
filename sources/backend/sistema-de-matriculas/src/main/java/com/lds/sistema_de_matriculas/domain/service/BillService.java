package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.domain.model.Bill;
import com.lds.sistema_de_matriculas.domain.model.CurriculumGrid;
import com.lds.sistema_de_matriculas.domain.model.Student;
import com.lds.sistema_de_matriculas.domain.repository.BillRepository;
import com.lds.sistema_de_matriculas.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BillService {

    private final BillRepository billRepository;
    private final StudentRepository studentRepository;

    public BillService(BillRepository billRepository, StudentRepository studentRepository) {
        this.billRepository = billRepository;
        this.studentRepository = studentRepository;
    }

    public Bill createBillForStudent(String studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Double billValue = calculateBillValue(student);

        Bill bill = new Bill(null, billValue, new Date(), false, student);
        return billRepository.save(bill);
    }

    private Double calculateBillValue(Student student) {
        CurriculumGrid lastCurriculumGrid = student.getLastCurriculumGrid();

        return lastCurriculumGrid.calcPrice();
    }

    public Bill getBillById(String id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
    }

    public Bill payBill(String id) {
        Bill bill = getBillById(id);
        bill.setPaid(true);
        return billRepository.save(bill);
    }

    public Iterable<Bill> getBillsByStudentId(String studentId) {
        return billRepository.findByStudentId(studentId);
    }
}