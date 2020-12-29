package com.dash;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dash.model.Employee;
import com.dash.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeService service = context.getBean(EmployeeService.class);
		List<Employee> listEmp = Arrays.asList(
					new Employee(101, "Kumar", "Software Developer", 60000.0),
					new Employee(102, "Sengu R", "Engineer", 50000.0),
					new Employee(103, "Sushma K", "Hr", 30000.0)
				);
		
		String response = service.saveEmployees(listEmp);
		System.out.println(response);
		
		Employee employee = service.getfindEmployeeByID(102);
		System.out.println(employee);
	}

}
