package com.adib.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Adib Mahfuj",
						email = "adibmahfuj@yahoo.com",
						url = "https://springbootnote.blogspot.com/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://springbootnote.blogspot.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service Docs",
				url = "https://springbootnote.blogspot.com"
		)
)

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
