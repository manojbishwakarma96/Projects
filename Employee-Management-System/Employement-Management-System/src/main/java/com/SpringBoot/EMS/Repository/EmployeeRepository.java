package com.SpringBoot.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.EMS.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
