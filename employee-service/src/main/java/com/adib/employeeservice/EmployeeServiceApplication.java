package com.adib.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Adib Mahfuj",
						email = "adibmahfuj@yahoo.com",
						url = "springbootnote.blogspot.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "sprinbootnote.blogspot.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service Doc",
				url = "springbootnote.blogspot.com"
		)
)

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

/*
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
*/

	@Bean
	public WebClient webClient()
	{
		return WebClient.builder().build();
	}

    public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
