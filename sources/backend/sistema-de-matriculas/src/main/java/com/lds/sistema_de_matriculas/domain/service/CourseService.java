package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.CourseDTO;
import com.lds.sistema_de_matriculas.application.mapper.CourseMapper;
import com.lds.sistema_de_matriculas.domain.model.Course;
import com.lds.sistema_de_matriculas.domain.model.Secretary;
import com.lds.sistema_de_matriculas.domain.repository.CourseRepository;
import com.lds.sistema_de_matriculas.domain.repository.SecretaryRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final SecretaryRepository secretaryRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, SecretaryRepository secretaryRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.secretaryRepository = secretaryRepository;
        this.courseMapper = courseMapper;
    }

    public Course createCourse(CourseDTO courseDTO) {
        Secretary secretary = secretaryRepository.findById(courseDTO.getSecretaryId())
                .orElseThrow(() -> new RuntimeException("Secretary not found with ID: " + courseDTO.getSecretaryId()));

        Course course = courseMapper.toCourse(courseDTO);
        course.setSecretary(secretary);
        return courseRepository.save(course);
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
    }

    public Course updateCourse(String id, CourseDTO courseDTO) {
        Course existingCourse = getCourseById(id);
        courseMapper.updateCourseFromDTO(courseDTO, existingCourse);

        if (courseDTO.getSecretaryId() != null) {
            Secretary secretary = secretaryRepository.findById(courseDTO.getSecretaryId())
                    .orElseThrow(() -> new RuntimeException("Secretary not found with ID: " + courseDTO.getSecretaryId()));
            existingCourse.setSecretary(secretary);
        }

        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}