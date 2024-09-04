package com.lds.sistema_de_matriculas.config;

import com.lds.sistema_de_matriculas.SistemaDeMatriculasApplication;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@DataMongoTest
@Import(SistemaDeMatriculasApplication.class)
public class ModelTestConfig {
}