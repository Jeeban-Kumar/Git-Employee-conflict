package com.dash.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dash.model.Employee;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	List<Employee> listEmps;
	@PostMapping(value = "/save")
	public ResponseEntity<String> registerAllEmps(@RequestBody List<Employee> listEmp) {
		listEmps = listEmp;
		System.out.println(listEmps);
		return new ResponseEntity<>("All Employees saved succesfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/{empId}/find")
	public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable Integer empId){
		for(Employee e : listEmps) {
			if(e.getEmpId() == empId) {
				return new ResponseEntity<Employee>(e,HttpStatus.OK);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}

}
