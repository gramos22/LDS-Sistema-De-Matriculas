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
class ProfessorTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateProfessorWithValidData() {
        Professor professor = new Professor(null, "Professor Name", "test@email.com", "password", new ArrayList<>(), new ArrayList<>(), null);
        mongoTemplate.save(professor);
        assertNotNull(professor.getId());
        assertEquals("Professor Name", professor.getName());
        assertEquals("test@email.com", professor.getEmail());
        assertEquals("password", professor.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, "  ", "test@email.com", "password", new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, null, "test@email.com", "password", new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithBlankEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, "Professor Name", "  ", "password", new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, "Professor Name", null, "password", new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, "Professor Name", "test", "password", new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithBlankPassword() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, "Professor Name", "test@email.com", "  ", new ArrayList<>(), new ArrayList<>(), null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingProfessorWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> new Professor(null, "Professor Name", "test@email.com", null, new ArrayList<>(), new ArrayList<>(), null));
    }
}