package com.dash.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private Integer empId;
	private String empName;
	private Double experience;
	private String job;
	private Integer age;
	private Double salary;
}
