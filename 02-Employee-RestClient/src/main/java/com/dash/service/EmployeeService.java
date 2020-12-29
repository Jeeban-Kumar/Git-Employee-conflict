package com.dash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dash.model.Employee;

@Component
public class EmployeeService {
	@Autowired
	private RestTemplate restTemplate;
	
	// Rest End point urls
	private static final String END_URL_POST = "http://localhost:9090/employee/save";
	private static final String END_URL_GET = "http://localhost:9090/employee/{empId}/find";
	
	//save employee objects by http POST
	public  String saveEmployees(List<Employee> list) {
		HttpEntity<List<Employee>> reqEntity = new HttpEntity<List<Employee>>(list);
		String res = "";
		ResponseEntity<String> response = restTemplate.exchange(END_URL_POST, HttpMethod.POST, reqEntity, String.class);
		if(response.getStatusCode() == HttpStatus.ACCEPTED) {
			res = response.getBody();
		}
		return res;
	}
	
	// Get employee by http GET
	
	public Employee getfindEmployeeByID(Integer empId) {
		
		ResponseEntity<Employee> responseEntity = restTemplate.getForEntity(END_URL_GET, Employee.class, empId);
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
		 Employee emp = responseEntity.getBody();
		 return emp;
		}
		
		return null;
	}
}
