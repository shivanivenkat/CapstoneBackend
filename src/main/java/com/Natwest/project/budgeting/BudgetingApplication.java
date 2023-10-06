package com.Natwest.project.budgeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BudgetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetingApplication.class, args);
	}

}
