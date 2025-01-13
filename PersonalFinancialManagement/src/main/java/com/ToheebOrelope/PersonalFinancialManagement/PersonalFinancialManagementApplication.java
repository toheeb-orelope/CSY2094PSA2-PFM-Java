package com.ToheebOrelope.PersonalFinancialManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


@OpenAPIDefinition(info = @Info(title = "Personal Financial Management API", version = "v0"))
@SpringBootApplication
public class PersonalFinancialManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinancialManagementApplication.class, args);
	}

}
//Using generated security password: efc3edec-b10a-43ad-994e-41ea9b031e62