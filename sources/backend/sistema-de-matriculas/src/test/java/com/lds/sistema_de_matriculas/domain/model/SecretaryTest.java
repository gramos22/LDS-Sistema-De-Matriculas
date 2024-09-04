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
class SecretaryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateSecretaryWithValidData() {
        Secretary secretary = new Secretary(null, "Secretary Name", "test@email.com", "password", new ArrayList<>());
        mongoTemplate.save(secretary);
        assertNotNull(secretary.getId());
        assertEquals("Secretary Name", secretary.getName());
        assertEquals("test@email.com", secretary.getEmail());
        assertEquals("password", secretary.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, "  ", "test@email.com", "password", new ArrayList<>()));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, null, "test@email.com", "password", new ArrayList<>()));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithBlankEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, "Secretary Name", "  ", "password", new ArrayList<>()));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, "Secretary Name", null, "password", new ArrayList<>()));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, "Secretary Name", "test", "password", new ArrayList<>()));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithBlankPassword() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, "Secretary Name", "test@email.com", "  ", new ArrayList<>()));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSecretaryWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> new Secretary(null, "Secretary Name", "test@email.com", null, new ArrayList<>()));
    }
}