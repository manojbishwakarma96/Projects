package com.SpringBoot.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.EMS.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}