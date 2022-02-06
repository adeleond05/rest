package com.parameta.springboot.backend.apirest.models.service;

import java.util.List;

import com.parameta.springboot.backend.apirest.models.entity.Employee;


public interface IEmployeeService {

	public Employee findEmployee(Employee empleado) throws Exception;
	
	
}
