package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.LeaveApplications;
import org.springframework.data.repository.CrudRepository;

public interface LeaveApplicationsRespository  extends CrudRepository<LeaveApplications,Integer> {
}
