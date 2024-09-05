package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.SubjectDTO;
import com.lds.sistema_de_matriculas.application.mapper.SubjectMapper;
import com.lds.sistema_de_matriculas.domain.model.Curriculum;
import com.lds.sistema_de_matriculas.domain.model.Professor;
import com.lds.sistema_de_matriculas.domain.model.Subject;
import com.lds.sistema_de_matriculas.domain.repository.CurriculumRepository;
import com.lds.sistema_de_matriculas.domain.repository.ProfessorRepository;
import com.lds.sistema_de_matriculas.domain.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final CurriculumRepository curriculumRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository,
                          CurriculumRepository curriculumRepository,
                          ProfessorRepository professorRepository,
                          SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.curriculumRepository = curriculumRepository;
        this.professorRepository = professorRepository;
        this.subjectMapper = subjectMapper;
    }

    public Subject createSubject(String curriculumId, SubjectDTO subjectDTO) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new RuntimeException("Curriculum not found with ID: " + curriculumId));

        Professor professor = professorRepository.findById(subjectDTO.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor not found with ID: " + subjectDTO.getProfessorId()));

        Subject subject = subjectMapper.toSubject(subjectDTO);
        subject.setCurriculum(curriculum);
        subject.setProfessor(professor);
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(String id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with ID: " + id));
    }

    public Subject updateSubject(String id, SubjectDTO subjectDTO) {
        Subject existingSubject = getSubjectById(id);
        subjectMapper.updateSubjectFromDTO(subjectDTO, existingSubject);

        if (subjectDTO.getCurriculumId() != null) {
            Curriculum curriculum = curriculumRepository.findById(subjectDTO.getCurriculumId())
                    .orElseThrow(() -> new RuntimeException("Curriculum not found with ID: " + subjectDTO.getCurriculumId()));
            existingSubject.setCurriculum(curriculum);
        }

        if (subjectDTO.getProfessorId() != null) {
            Professor professor = professorRepository.findById(subjectDTO.getProfessorId())
                    .orElseThrow(() -> new RuntimeException("Professor not found with ID: " + subjectDTO.getProfessorId()));
            existingSubject.setProfessor(professor);
        }

        return subjectRepository.save(existingSubject);
    }

    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }

    public Iterable<Subject> getSubjectsByCurriculumId(String curriculumId) {
        return subjectRepository.findByCurriculumId(curriculumId);
    }
}