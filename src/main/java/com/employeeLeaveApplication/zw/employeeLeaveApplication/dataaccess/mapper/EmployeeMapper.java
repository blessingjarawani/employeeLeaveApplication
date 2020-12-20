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
                    @Mapping(target = "id", source = "entity.id"),
                    @Mapping(target = "empCode", source = "entity.empCode"),
                    @Mapping(target = "lastName", source = "entity.lastName"),
                    @Mapping(target = "firstName", source = "entity.firstName"),
                    @Mapping(target = "dateOfBirth", source = "entity.dateOfBirth"),
                    @Mapping(target = "gender", source = "entity.gender"),
                    @Mapping(target = "department", source = "entity.department"),
                    @Mapping(target = "company", source = "entity.company"),
                    @Mapping(target = "leaveApplications", source = "entity.leaveApplication")
            })
    EmployeeDTO EntityToDTO(Employees entity);

    @Mappings({
            @Mapping(target = "id", source = "employeeDTO.id"),
            @Mapping(target = "empCode", source = "employeeDTO.empCode"),
            @Mapping(target = "lastName", source = "employeeDTO.lastName"),
            @Mapping(target = "firstName", source = "employeeDTO.firstName"),
            @Mapping(target = "dateOfBirth", source = "employeeDTO.dateOfBirth"),
            @Mapping(target = "gender", source = "employeeDTO.gender"),
            @Mapping(target = "department.id", source = "employeeDTO.departmentId"),
            @Mapping(target = "company.id", source = "employeeDTO.companyId")
    })

    Employees DTOToEntity(EmployeeDTO employeeDTO);
    List<EmployeeDTO>Map (Iterable<Employees> employees);
}
