package com.lds.sistema_de_matriculas.domain.model;

import java.util.List;

import com.lds.sistema_de_matriculas.domain.DomainConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("professors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professor {

    @Id
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @DBRef
    private List<Subject> subjects;

    @DBRef
    private List<Paycheck> paychecks;

    @DBRef
    private Address address;

    public double calcSalary() {
        return DomainConstants.PROFESSOR_BASE_SALARY +
                (DomainConstants.PROFESSOR_BASE_SALARY * (subjects.size() / 100.0));
    }
}