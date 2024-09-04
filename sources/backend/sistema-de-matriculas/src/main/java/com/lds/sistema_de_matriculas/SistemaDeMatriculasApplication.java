package com.lds.sistema_de_matriculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.lds.sistema_de_matriculas.domain.repository")
public class SistemaDeMatriculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeMatriculasApplication.class, args);
	}

}
