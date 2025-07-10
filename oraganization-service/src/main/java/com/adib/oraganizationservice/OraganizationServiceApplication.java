package com.adib.oraganizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Adib Mahfuj",
						email = "adibmahfuj@yahoo.com",
						url = "springbootnote.blogspot.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "springbootnote.blogspot.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service Doc",
				url = "springbootnote.blogspot.com"
		)

)
@SpringBootApplication
public class OraganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run  (OraganizationServiceApplication.class, args);
	}

}
