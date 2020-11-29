package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.EmployeeLeaveApplication;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Employees;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.EmployeeDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.LeaveApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel ="spring")
public interface EmployeeMapper {
    @Mappings(
            {
                    @Mapping(target = "Id", source = "entity.Id"),
                    @Mapping(target = "EmpCode", source = "entity.EmpCode"),
                    @Mapping(target = "LastName", source = "entity.LastName"),
                    @Mapping(target = "FirstName", source = "entity.FirstName"),
                    @Mapping(target = "DateOfBirth", source = "entity.DateOfBirth"),
                    @Mapping(target = "Gender", source = "entity.Gender"),
                    @Mapping(target = "Department", source = "entity.Department"),
                    @Mapping(target = "Company", source = "entity.Company"),
                    @Mapping(target = "LeaveApplications", source = "entity.LeaveApplication")
            })
    EmployeeDTO EntityToDTO(Employees entity);

    @Mappings({
            @Mapping(target = "Id", source = "employeeDTO.Id"),
            @Mapping(target = "EmpCode", source = "employeeDTO.EmpCode"),
            @Mapping(target = "LastName", source = "employeeDTO.LastName"),
            @Mapping(target = "FirstName", source = "employeeDTO.FirstName"),
            @Mapping(target = "DateOfBirth", source = "employeeDTO.DateOfBirth"),
            @Mapping(target = "Gender", source = "employeeDTO.Gender"),
            @Mapping(target = "DepartmentId", source = "employeeDTO.Department.Id"),
            @Mapping(target = "CompanyId", source = "employeeDTO.Company.Id")
    })

    Employees DTOToEntity(EmployeeDTO employeeDTO);
    List<EmployeeDTO>Map (Iterable<Employees> employees);
}
