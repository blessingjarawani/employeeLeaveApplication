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
             @Mapping(target = "Id", source = "department.Id"),
            @Mapping(target = "Name", source = "department.Name"),
    })

    DepartmentDTO EntityToDTO(Department department);

    @Mappings({
            @Mapping(target = "Id", source = "dto.Id"),
            @Mapping(target = "Name", source = "dto.Name"),
    })
    Department DTOToEntity(DepartmentDTO dto);
    List<DepartmentDTO>Map(Iterable<Department> departments);
}
