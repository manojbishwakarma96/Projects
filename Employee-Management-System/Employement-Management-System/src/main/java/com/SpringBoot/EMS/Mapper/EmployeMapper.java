package com.SpringBoot.EMS.Mapper;

import com.SpringBoot.EMS.Entity.Employee;
import com.SpringBoot.EMS.dto.EmployeeDto;

public class EmployeMapper {
	public static EmployeeDto mapTOEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail());
				
	}

	public static Employee mapToEmployeeEntity(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}
}