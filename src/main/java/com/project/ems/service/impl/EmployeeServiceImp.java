package com.project.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ems.dto.EmployeeDto;
import com.project.ems.entity.Employeess;
import com.project.ems.exceptions.ResourceNotFound;
import com.project.ems.mapper.EmployeeMapper;
import com.project.ems.repository.Repository;
import com.project.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

	private Repository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employeess employee=EmployeeMapper.mapToEmployee(employeeDto);
	    Employeess savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
	 Employeess employee= employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFound("Employee is not exists with a given id:"+employeeId));
	     return EmployeeMapper.mapToEmployeeDto(employee);
		
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employeess> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = new ArrayList<>();

		for (Employeess emp : employees) {
			EmployeeDto dto = EmployeeMapper.mapToEmployeeDto(emp);
			employeeDtos.add(dto);
		}

		return employeeDtos;
	}

	@Override
	public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto updatedEmployee) {
		Employeess employee=employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFound("Employee is not exist with a given id:"+ employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		 Employeess updatedemp = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedemp);
		
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employeess employee= employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Employee is not exists with a given id:"+id));
		
		employeeRepository.deleteById(id);
	}

}
