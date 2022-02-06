package com.parameta.springboot.backend.apirest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parameta.springboot.backend.apirest.models.entity.Employee;
import com.parameta.springboot.backend.apirest.models.service.IEmployeeService;
import com.parameta.springboot.backend.apirest.util.Functions;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<?> getEmployees(@Valid @RequestBody Employee employee) throws Exception{
		

			 if(!Functions.validateAge(employee.getDateBirthday())) {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("El empleado no es mayor de edad");
			 }

			 return  ResponseEntity.status(HttpStatus.CREATED)
				.body(	employeeService.findEmployee(employee));

	}
}
