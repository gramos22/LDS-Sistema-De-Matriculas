package com.lds.sistema_de_matriculas.domain.model;

import com.lds.sistema_de_matriculas.config.ModelTestConfig;
import com.lds.sistema_de_matriculas.domain.enums.SubjectStatusEnum;
import com.lds.sistema_de_matriculas.domain.enums.SubjectTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(ModelTestConfig.class)
class SubjectTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateSubjectWithValidData() {
        Curriculum curriculum = new Curriculum(null, 10.0, null, true, null, null);
        mongoTemplate.save(curriculum);
        Professor professor = new Professor(null, "Professor Name", "test@email.com", "password", null, null, null);
        mongoTemplate.save(professor);

        Subject subject = new Subject(null, "Subject Name", 4.5, "SEG 10:00", SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, 1000.00, curriculum, professor);
        mongoTemplate.save(subject);
        assertNotNull(subject.getId());
        assertEquals("Subject Name", subject.getName());
        assertEquals(4.5, subject.getCredit());
        assertEquals("SEG 10:00", subject.getSchedule());
        assertEquals(SubjectTypeEnum.MANDATORY, subject.getType());
        assertEquals(SubjectStatusEnum.OPEN, subject.getStatus());
        assertEquals(1000.00, subject.getPrice());
        assertEquals(curriculum, subject.getCurriculum());
        assertEquals(professor, subject.getProfessor());
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithNullName() {
        assertThrows(IllegalArgumentException.class, () ->  new Subject(null, null, 4.5, "SEG 10:00", SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithBlankName() {
        assertThrows(IllegalArgumentException.class, () ->  new Subject(null, "  ", 4.5, "SEG 10:00", SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithNullCredit() {
        assertThrows(IllegalArgumentException.class, () ->  new Subject(null, "Subject Name", null, "SEG 10:00", SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithNullSchedule() {
        assertThrows(IllegalArgumentException.class, () ->  new Subject(null, "Subject Name", 4.5, null, SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithBlankSchedule() {
        assertThrows(IllegalArgumentException.class, () -> new Subject(null, "Subject Name", 4.5, "  ", SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithNullType() {
        assertThrows(IllegalArgumentException.class, () ->  new Subject(null, "Subject Name", 4.5, "SEG 10:00", null, SubjectStatusEnum.OPEN, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithNullStatus() {
        assertThrows(IllegalArgumentException.class, () -> new Subject(null, "Subject Name", 4.5, "SEG 10:00", SubjectTypeEnum.MANDATORY, null, 1000.00, null, null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingSubjectWithNullPrice() {
        assertThrows(IllegalArgumentException.class, () ->  new Subject(null, "Subject Name", 4.5, "SEG 10:00", SubjectTypeEnum.MANDATORY, SubjectStatusEnum.OPEN, null, null, null));
    }
}