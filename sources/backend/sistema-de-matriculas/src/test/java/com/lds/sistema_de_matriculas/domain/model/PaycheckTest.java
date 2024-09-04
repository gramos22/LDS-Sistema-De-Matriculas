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
class PaycheckTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreatePaycheckWithValidData() {
        Professor professor = new Professor(null, "Professor Name", "test@email.com", "password", new ArrayList<>(), new ArrayList<>(), null);
        mongoTemplate.save(professor);

        Paycheck paycheck = new Paycheck(null, 5000.00, new Date(), false, professor);
        mongoTemplate.save(paycheck);
        assertNotNull(paycheck.getId());
        assertEquals(5000.00, paycheck.getValue());
        assertFalse(paycheck.isPaid());
        assertEquals(professor, paycheck.getProfessor());
    }

    @Test
    void shouldThrowExceptionWhenCreatingPaycheckWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Professor professor = new Professor(null, "Professor Name", "test@email.com", "password", new ArrayList<>(), new ArrayList<>(), null);
            new Paycheck(null, null, new Date(), false, professor);
        });
    }
}