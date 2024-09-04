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
class CurriculumGridTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateCurriculumGridWithValidData() {
        Student student = new Student(null, "Name", "test@email.com",  "password", null, null, null, null);
        mongoTemplate.save(student);

        CurriculumGrid curriculumGrid = new CurriculumGrid(null, new Date(), false, false, student, new ArrayList<>());
        mongoTemplate.save(curriculumGrid);
        assertNotNull(curriculumGrid.getId());
        assertFalse(curriculumGrid.isDeferred());
        assertFalse(curriculumGrid.isCompleted());
        assertEquals(student, curriculumGrid.getStudent());
    }
}