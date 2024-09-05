package com.lds.sistema_de_matriculas.domain.model;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("bills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {
    @Id
    private String id;
    private Double price;
    private Date dueDate;
    private boolean isPaid;
    @DBRef
    private Student student;
}
