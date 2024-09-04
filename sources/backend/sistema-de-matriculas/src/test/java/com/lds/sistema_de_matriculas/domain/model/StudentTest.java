package com.lds.sistema_de_matriculas.domain.model;

import com.lds.sistema_de_matriculas.config.ModelTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(ModelTestConfig.class)
class StudentTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateStudentWithValidData() {
        Student student = new Student(null, "Student Name", "test@email.com", "password", null, new ArrayList<>(), new ArrayList<>(), null);
        mongoTemplate.save(student);
        assertNotNull(student.getId());
        assertEquals("Student Name", student.getName());
        assertEquals("test@email.com", student.getEmail());
        assertEquals("password", student.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithBlankName() {
        assertThrows(IllegalArgumentException.class, () ->  new Student(null, "  ", "test@email.com", "password", null, new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, null, "test@email.com", "password", null, new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithBlankEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "Student Name", "  ", "password", null, new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "Student Name", null, "password", null, new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->  new Student(null, "Student Name", "test", "password", null, new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithBlankPassword() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "Student Name", "test@email.com", "  ", null, new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingStudentWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () ->  new Student(null, "Student Name", "test@email.com", null, null, new ArrayList<>(), new ArrayList<>(), null));
    }
}