package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<Department, Integer> {
}
