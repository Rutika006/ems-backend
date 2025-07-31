package com.project.ems.service;

import java.util.List;

import com.project.ems.dto.EmployeeDto;

public interface EmployeeService {
   EmployeeDto createEmployee(EmployeeDto employeeDto);
   EmployeeDto getEmployeeById(Long id);
  List<EmployeeDto>getAllEmployees();
  EmployeeDto updateEmployeeById(Long employeeId,EmployeeDto updatedEmployee);
  void deleteEmployeeById(Long id);
}
