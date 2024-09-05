package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.PaycheckDTO;
import com.lds.sistema_de_matriculas.application.mapper.PaycheckMapper;
import com.lds.sistema_de_matriculas.domain.model.Paycheck;
import com.lds.sistema_de_matriculas.domain.model.Professor;
import com.lds.sistema_de_matriculas.domain.repository.PaycheckRepository;
import com.lds.sistema_de_matriculas.domain.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaycheckService {

    private final PaycheckRepository paycheckRepository;
    private final ProfessorRepository professorRepository;
    private final PaycheckMapper paycheckMapper;

    public PaycheckService(PaycheckRepository paycheckRepository, ProfessorRepository professorRepository, PaycheckMapper paycheckMapper) {
        this.paycheckRepository = paycheckRepository;
        this.professorRepository = professorRepository;
        this.paycheckMapper = paycheckMapper;
    }

    public Paycheck createPaycheckForProfessor(String professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found with ID: " + professorId));

        Double paycheckValue = calculatePaycheckValue(professor);

        Paycheck paycheck = new Paycheck(null, paycheckValue, new Date(), false, professor);
        return paycheckRepository.save(paycheck);
    }

    private Double calculatePaycheckValue(Professor professor) {
        return professor.calcSalary();
    }

    public Paycheck getPaycheckById(String id) {
        return paycheckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paycheck not found with ID: " + id));
    }

    public Paycheck payPaycheck(String id) {
        Paycheck paycheck = getPaycheckById(id);
        paycheck.setPaid(true);
        return paycheckRepository.save(paycheck);
    }

    public Iterable<Paycheck> getPaychecksByProfessorId(String professorId) {
        return paycheckRepository.findByProfessorId(professorId);
    }
}