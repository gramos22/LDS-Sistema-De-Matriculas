package com.lds.sistema_de_matriculas.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("addresses") // Nome da coleção no MongoDB
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    private String id;

    @NotBlank(message = "Street cannot be blank")
    private String street;

    private Integer number;

    @NotBlank(message = "Neighborhood cannot be blank")
    private String neighborhood;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Zip code cannot be blank")
    private String zipCode;
}