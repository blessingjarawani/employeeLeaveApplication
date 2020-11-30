package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository  extends CrudRepository<Company, Integer> {
}
