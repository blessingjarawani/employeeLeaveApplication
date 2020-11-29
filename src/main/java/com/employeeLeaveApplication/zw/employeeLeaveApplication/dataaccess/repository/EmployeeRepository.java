package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends CrudRepository<Employees,Integer> {
}
