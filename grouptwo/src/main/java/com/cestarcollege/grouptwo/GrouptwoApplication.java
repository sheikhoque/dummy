package com.cestarcollege.grouptwo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cestarcollege.grouptwo.model.Employee;
import com.cestarcollege.grouptwo.repo.EmployeeRepository;

@SpringBootApplication
public class GrouptwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrouptwoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(EmployeeRepository employeeRepository) {
		return (args) -> {
			employeeRepository.save(new Employee("Gustavo", "Ponce", true));
			employeeRepository.save(new Employee("John", "Smith", true));
			employeeRepository.save(new Employee("Jim ", "Morrison", false));
			employeeRepository.save(new Employee("David", "Gilmour", true));
			};
	}
}
