package com.ToheebOrelope.PersonalFinancialManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info = @Info(title = "Personal Financial Management API", version = "v0"))
@SpringBootApplication
public class PersonalFinancialManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinancialManagementApplication.class, args);
	}

}
//Using generated security password: efc3edec-b10a-43ad-994e-41ea9b031e62