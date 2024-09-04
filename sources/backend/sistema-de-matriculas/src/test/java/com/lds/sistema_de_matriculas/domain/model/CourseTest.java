package com.lds.sistema_de_matriculas.domain.model;

import com.lds.sistema_de_matriculas.config.ModelTestConfig;
import com.lds.sistema_de_matriculas.domain.enums.CourseTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(ModelTestConfig.class)
class CourseTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateCourseWithValidData() {
        Secretary secretary = new Secretary(null, "Name", "test@test.com", "password", new ArrayList<>());
        mongoTemplate.save(secretary);

        Course course = new Course(null, "Computer Science", CourseTypeEnum.BACHELORS, secretary, new ArrayList<>(), new ArrayList<>());
        mongoTemplate.save(course);
        assertNotNull(course.getId());
        assertEquals("Computer Science", course.getName());
        assertEquals(CourseTypeEnum.BACHELORS, course.getType());
        assertEquals(secretary, course.getSecretary());
    }

    @Test
    void shouldThrowExceptionWhenCreatingCourseWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Secretary secretary = new Secretary(null, "Name", "test@test.com", "password", new ArrayList<>());
            new Course(null, null, CourseTypeEnum.BACHELORS, secretary, new ArrayList<>(), new ArrayList<>());
        });
    }

    @Test
    void shouldThrowExceptionWhenCreatingCourseWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Secretary secretary = new Secretary(null, "Name", "test@test.com", "password", new ArrayList<>());
            new Course(null, "  ", CourseTypeEnum.BACHELORS, secretary, new ArrayList<>(), new ArrayList<>());
        });
    }

    @Test
    void shouldThrowExceptionWhenCreatingCourseWithNullType() {
        assertThrows(IllegalArgumentException.class, () -> {
            Secretary secretary = new Secretary(null, "Name", "test@test.com", "password", new ArrayList<>());
            new Course(null, "Computer Science", null, secretary, new ArrayList<>(), new ArrayList<>());
        });
    }
}