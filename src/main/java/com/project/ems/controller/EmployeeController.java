package com.project.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ems.dto.EmployeeDto;
import com.project.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin( origins = "https://rutika006.github.io")

@RestController
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeeController {
	private EmployeeService employeeService;

	
	//build add employee rest api
	@PostMapping
	public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployeeDto=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployeeDto,HttpStatus.CREATED);
	}
	//build get employee rest api
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id")  Long employeeId){
		EmployeeDto employeeDto=  employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	//Build get all employee rest api
	@GetMapping
	public ResponseEntity<List<EmployeeDto>>getAllEmployees(EmployeeDto employeeDto){
		List<EmployeeDto>employee=employeeService.getAllEmployees();
		return ResponseEntity.ok(employee);
	}
	
	//Build api to update employee
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto>updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto=employeeService.updateEmployeeById(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	//Build api to delete by id
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteEmployeeById(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Employee deleted sucessfully");
	}
}
