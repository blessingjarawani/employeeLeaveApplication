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
            @Mapping(target = "Id", source = "company.Id"),
            @Mapping(target = "Name", source = "company.Name"),
    })
    DepartmentDTO EntityToDTO(Company company);

    @Mappings({
            @Mapping(target = "Id", source = "dto.Id"),
            @Mapping(target = "Name", source = "dto.Name"),
    })
    Company DTOToEntity(CompanyDTO dto);
    List<CompanyDTO> Map(Iterable<Company> companies);
}
