package com.lds.sistema_de_matriculas.domain.model;

import com.lds.sistema_de_matriculas.config.ModelTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataMongoTest
@Import(ModelTestConfig.class)
class AddressTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateAddressWithValidData() {
        Address address = new Address(null, "Street", 123, "Neighborhood", "City", "State", "12345-678");
        mongoTemplate.save(address);
        assertNotNull(address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals(123, address.getNumber());
        assertEquals("Neighborhood", address.getNeighborhood());
        assertEquals("City", address.getCity());
        assertEquals("State", address.getState());
        assertEquals("12345-678", address.getZipCode());
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithBlankStreet() {
        assertThrows(IllegalArgumentException.class, () -> new Address(null, "  ", 123, "Neighborhood", "City", "State", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithNullStreet() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, null, 123, "Neighborhood", "City", "State", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithBlankNeighborhood() {
        assertThrows(IllegalArgumentException.class, () -> new Address(null, "Street", 123, "  ", "City", "State", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithNullNeighborhood() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, "Street", 123, null, "City", "State", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithBlankCity() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, "Street", 123, "Neighborhood", "  ", "State", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithNullCity() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, "Street", 123, "Neighborhood", null, "State", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithBlankState() {
        assertThrows(IllegalArgumentException.class, () -> new Address(null, "Street", 123, "Neighborhood", "City", "  ", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithNullState() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, "Street", 123, "Neighborhood", "City", null, "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithBlankZipCode() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, "Street", 123, "Neighborhood", "City", "State", "  "));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithNullZipCode() {
        assertThrows(IllegalArgumentException.class, () -> new Address(null, "Street", 123, "Neighborhood", "City", "State", null));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAddressWithInvalidZipCode() {
        assertThrows(IllegalArgumentException.class, () ->  new Address(null, "Street", 123, "Neighborhood", "City", "State", "12345678"));
    }
}