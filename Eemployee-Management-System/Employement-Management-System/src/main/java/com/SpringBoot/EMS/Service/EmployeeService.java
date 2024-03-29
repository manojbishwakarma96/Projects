package com.SpringBoot.EMS.Service;
import java.util.List;

import com.SpringBoot.EMS.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto getEmployeeByID(Long employeeId);
	public List<EmployeeDto> getAllEmployee();
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);
	public void deleteEmployee(Long id);

}
