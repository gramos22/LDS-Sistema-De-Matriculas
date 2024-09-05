package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.CurriculumGridDTO;
import com.lds.sistema_de_matriculas.application.mapper.CurriculumGridMapper;
import com.lds.sistema_de_matriculas.domain.model.CurriculumGrid;
import com.lds.sistema_de_matriculas.domain.model.Student;
import com.lds.sistema_de_matriculas.domain.model.Subject;
import com.lds.sistema_de_matriculas.domain.repository.CurriculumGridRepository;
import com.lds.sistema_de_matriculas.domain.repository.StudentRepository;
import com.lds.sistema_de_matriculas.domain.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CurriculumGridService {

    private final CurriculumGridRepository curriculumGridRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final CurriculumGridMapper curriculumGridMapper;

    public CurriculumGridService(CurriculumGridRepository curriculumGridRepository,
                                 StudentRepository studentRepository,
                                 SubjectRepository subjectRepository,
                                 CurriculumGridMapper curriculumGridMapper) {
        this.curriculumGridRepository = curriculumGridRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.curriculumGridMapper = curriculumGridMapper;
    }

    public CurriculumGrid createCurriculumGrid(String studentId, CurriculumGridDTO curriculumGridDTO) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        List<Subject> subjects = subjectRepository.findAllById(curriculumGridDTO.getSubjectIds());

        CurriculumGrid curriculumGrid = curriculumGridMapper.toCurriculumGrid(curriculumGridDTO);
        curriculumGrid.setStudent(student);
        curriculumGrid.setSubjects(subjects);

        return curriculumGridRepository.save(curriculumGrid);
    }

    public CurriculumGrid getCurriculumGridById(String id) {
        return curriculumGridRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculum Grid not found with ID: " + id));
    }

    public CurriculumGrid updateCurriculumGrid(String id, CurriculumGridDTO curriculumGridDTO) {
        CurriculumGrid existingCurriculumGrid = getCurriculumGridById(id);
        curriculumGridMapper.updateCurriculumGridFromDTO(curriculumGridDTO, existingCurriculumGrid);

        if (curriculumGridDTO.getStudentId() != null) {
            Student student = studentRepository.findById(curriculumGridDTO.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with ID: " + curriculumGridDTO.getStudentId()));
            existingCurriculumGrid.setStudent(student);
        }

        if (curriculumGridDTO.getSubjectIds() != null) {
            List<Subject> subjects = subjectRepository.findAllById(curriculumGridDTO.getSubjectIds());
            existingCurriculumGrid.setSubjects(subjects);
        }

        return curriculumGridRepository.save(existingCurriculumGrid);
    }

    public void deleteCurriculumGrid(String id) {
        curriculumGridRepository.deleteById(id);
    }

    public Iterable<CurriculumGrid> getCurriculumGridsByStudentId(String studentId) {
        return curriculumGridRepository.findByStudentId(studentId);
    }
}