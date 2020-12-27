package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Company;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.CompanyDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mappings({
            @Mapping(target = "id", source = "company.id"),
            @Mapping(target = "name", source = "company.name"),
    })
    CompanyDTO EntityToDTO(Company company);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "name", source = "dto.name"),
    })
    Company DTOToEntity(CompanyDTO dto);
    List<CompanyDTO> Map(Iterable<Company> companies);
}
