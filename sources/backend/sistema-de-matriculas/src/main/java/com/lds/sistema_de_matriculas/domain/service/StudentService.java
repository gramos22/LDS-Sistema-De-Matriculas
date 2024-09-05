package com.lds.sistema_de_matriculas.domain.service;

import com.lds.sistema_de_matriculas.application.dto.StudentDTO;
import com.lds.sistema_de_matriculas.application.mapper.StudentMapper;
import com.lds.sistema_de_matriculas.domain.model.Address;
import com.lds.sistema_de_matriculas.domain.model.Course;
import com.lds.sistema_de_matriculas.domain.model.Student;
import com.lds.sistema_de_matriculas.domain.repository.AddressRepository;
import com.lds.sistema_de_matriculas.domain.repository.CourseRepository;
import com.lds.sistema_de_matriculas.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final AddressRepository addressRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository,
                          AddressRepository addressRepository,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.addressRepository = addressRepository;
        this.studentMapper = studentMapper;
    }

    public Student createStudent(StudentDTO studentDTO) {
        Course course = courseRepository.findById(studentDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + studentDTO.getCourseId()));

        Address address = addressRepository.findById(studentDTO.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + studentDTO.getAddressId()));

        Student student = studentMapper.toStudent(studentDTO);
        student.setCourse(course);
        student.setAddress(address);
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    public Student updateStudent(String id, StudentDTO studentDTO) {
        Student existingStudent = getStudentById(id);
        studentMapper.updateStudentFromDTO(studentDTO, existingStudent);

        if (studentDTO.getCourseId() != null) {
            Course course = courseRepository.findById(studentDTO.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with ID: " + studentDTO.getCourseId()));
            existingStudent.setCourse(course);
        }

        if (studentDTO.getAddressId() != null) {
            Address address = addressRepository.findById(studentDTO.getAddressId())
                    .orElseThrow(() -> new RuntimeException("Address not found with ID: " + studentDTO.getAddressId()));
            existingStudent.setAddress(address);
        }

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}