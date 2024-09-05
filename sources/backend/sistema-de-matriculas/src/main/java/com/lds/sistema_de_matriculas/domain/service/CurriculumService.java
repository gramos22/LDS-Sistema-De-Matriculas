package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.CurriculumDTO;
import com.lds.sistema_de_matriculas.application.mapper.CurriculumMapper;
import com.lds.sistema_de_matriculas.domain.model.Course;
import com.lds.sistema_de_matriculas.domain.model.Curriculum;
import com.lds.sistema_de_matriculas.domain.model.Subject;
import com.lds.sistema_de_matriculas.domain.repository.CourseRepository;
import com.lds.sistema_de_matriculas.domain.repository.CurriculumRepository;
import com.lds.sistema_de_matriculas.domain.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final CurriculumMapper curriculumMapper;

    public CurriculumService(CurriculumRepository curriculumRepository,
                             CourseRepository courseRepository,
                             SubjectRepository subjectRepository,
                             CurriculumMapper curriculumMapper) {
        this.curriculumRepository = curriculumRepository;
        this.courseRepository = courseRepository;
        this.subjectRepository = subjectRepository;
        this.curriculumMapper = curriculumMapper;
    }

    public Curriculum createCurriculum(String courseId, CurriculumDTO curriculumDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        List<Subject> subjects = subjectRepository.findAllById(curriculumDTO.getSubjectIds());

        Curriculum curriculum = curriculumMapper.toCurriculum(curriculumDTO);
        curriculum.setCourse(course);
        curriculum.setSubjects(subjects);
        return curriculumRepository.save(curriculum);
    }

    public Curriculum getCurriculumById(String id) {
        return curriculumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculum not found with ID: " + id));
    }

    public Curriculum updateCurriculum(String id, CurriculumDTO curriculumDTO) {
        Curriculum existingCurriculum = getCurriculumById(id);
        curriculumMapper.updateCurriculumFromDTO(curriculumDTO, existingCurriculum);

        if (curriculumDTO.getCourseId() != null) {
            Course course = courseRepository.findById(curriculumDTO.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with ID: " + curriculumDTO.getCourseId()));
            existingCurriculum.setCourse(course);
        }

        if (curriculumDTO.getSubjectIds() != null) {
            List<Subject> subjects = subjectRepository.findAllById(curriculumDTO.getSubjectIds());
            existingCurriculum.setSubjects(subjects);
        }

        return curriculumRepository.save(existingCurriculum);
    }

    public void deleteCurriculum(String id) {
        curriculumRepository.deleteById(id);
    }

    public Iterable<Curriculum> getCurriculumsByCourseId(String courseId) {
        return curriculumRepository.findByCourseId(courseId);
    }
}