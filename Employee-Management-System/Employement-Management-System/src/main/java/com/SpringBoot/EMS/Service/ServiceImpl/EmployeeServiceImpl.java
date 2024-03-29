package com.SpringBoot.EMS.Service.ServiceImpl;


import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.SpringBoot.EMS.Entity.Employee;
import com.SpringBoot.EMS.Exception.ResourseNotFoundException;
import com.SpringBoot.EMS.Mapper.EmployeMapper;
import com.SpringBoot.EMS.Repository.EmployeeRepository;
import com.SpringBoot.EMS.Service.EmployeeService;
import com.SpringBoot.EMS.dto.EmployeeDto;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	


	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeMapper.mapToEmployeeEntity(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		
		return EmployeMapper.mapTOEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeByID(Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId)
		.orElseThrow(
				()->new ResourseNotFoundException
				("Employee Does not Exist with the given id : "+employeeId ));
		return EmployeMapper.mapTOEmployeeDto(employee);
	}



	@Override
	public List<EmployeeDto>  getAllEmployee( ) {
		List<Employee> employee=employeeRepository.findAll();  
		return employee.stream().map((emp)->EmployeMapper
				.mapTOEmployeeDto(emp)).collect(Collectors.toList());
	}



	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId)
				.orElseThrow(
						()->new ResourseNotFoundException
						("Employee Does not Exist with the given id : "+employeeId ));
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeMapper.mapTOEmployeeDto(savedEmployee);
	}



	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId)
				.orElseThrow(
						()->new ResourseNotFoundException
						("Employee Does not Exist with the given id : "+employeeId ));
		employeeRepository.delete(employee);
	}
	
}
