package com.project.ems.mapper;

import com.project.ems.dto.EmployeeDto;
import com.project.ems.entity.Employeess;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employeess employee) {
		return new EmployeeDto(
		       employee.getId(),
		       employee.getFirstName(),
		       employee.getLastName(),
		       employee.getEmail()	
		);
				
	}
	
	public static Employeess mapToEmployee(EmployeeDto employeeDto) {
		return new Employeess(
			employeeDto.getId(),
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail()		
		);
	}
}
