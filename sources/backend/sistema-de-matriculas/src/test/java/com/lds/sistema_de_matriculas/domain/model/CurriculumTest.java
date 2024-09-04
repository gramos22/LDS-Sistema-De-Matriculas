package com.lds.sistema_de_matriculas.domain.model;

import com.lds.sistema_de_matriculas.config.ModelTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(ModelTestConfig.class)
class CurriculumTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateCurriculumWithValidData() {
        Course course = new Course(null, "Computer Science", null, null, null, null);
        mongoTemplate.save(course);

        Curriculum curriculum = new Curriculum(null, 5.5, new Date(), true, course, new ArrayList<>());
        mongoTemplate.save(curriculum);
        assertNotNull(curriculum.getId());
        assertEquals(5.5, curriculum.getSemesterNumber());
        assertTrue(curriculum.isActive());
        assertEquals(course, curriculum.getCourse());
    }

    @Test
    void shouldThrowExceptionWhenCreatingCurriculumWithNullSemesterNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Course course = new Course(null, "Computer Science", null, null, null, null);
            new Curriculum(null, null, new Date(), true, course, new ArrayList<>());
        });
    }
}