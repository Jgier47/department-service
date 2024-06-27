package net.java.app.department_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info =
        @Info(
            title = "Department Service REST APIs",
            description = "Department Service REST APIs Documentation",
            version = "v1.0"))
public class DepartmentServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DepartmentServiceApplication.class, args);
  }
}
