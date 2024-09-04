package com.lds.sistema_de_matriculas.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import com.lds.sistema_de_matriculas.config.ModelTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

@DataMongoTest
@Import(ModelTestConfig.class)
class BillTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateBillWithValidData() {
        Student student = new Student(null, "Name", "test@email.com",  "password", null, null, null, null);
        mongoTemplate.save(student);

        Bill bill = new Bill(null, 1500.00, new Date(), false, student);
        mongoTemplate.save(bill);
        assertNotNull(bill.getId());
        assertEquals(1500.00, bill.getPrice());
        assertFalse(bill.isPaid());
        assertEquals(student, bill.getStudent());
    }

    @Test
    void shouldThrowExceptionWhenCreatingBillWithNullPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(null, "Name", "test@email.com",  "password", null, null, null, null);
            new Bill(null, null, new Date(), false, student);
        });
    }
}