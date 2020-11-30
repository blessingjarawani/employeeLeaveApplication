package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mappings({
             @Mapping(target = "id", source = "department.id"),
            @Mapping(target = "name", source = "department.name"),
    })

    DepartmentDTO EntityToDTO(Department department);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "name", source = "dto.name"),
    })
    Department DTOToEntity(DepartmentDTO dto);
    List<DepartmentDTO>Map(Iterable<Department> departments);
}
