package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.LeaveApplications;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.LeaveApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel ="spring")
public interface LeaveApplicationsMapper {
@Mappings({
        @Mapping(target = "EmployeeId", source = "entity.EmployeeId"),
        @Mapping(target = "Id", source = "entity.Id"),
        @Mapping(target = "LeaveType", source = "entity.LeaveType"),
        @Mapping(target = "DateFrom", source = "entity.DateFrom"),
        @Mapping(target = "DateTo", source = "entity.DateTo"),
        @Mapping(target = "DaysTaken", source = "entity.DaysTaken"),
        @Mapping(target = "Comment", source = "entity.Comment")
})
    LeaveApplicationDTO EntityToDTO(LeaveApplications entity);

    @Mappings({
            @Mapping(target = "EmployeeId", source = "leaveApplicationDTO.EmployeeId"),
            @Mapping(target = "Id", source = "leaveApplicationDTO.Id"),
            @Mapping(target = "LeaveType", source = "leaveApplicationDTO.LeaveType"),
            @Mapping(target = "DateFrom", source = "leaveApplicationDTO.DateFrom"),
            @Mapping(target = "DateTo", source = "leaveApplicationDTO.DateTo"),
            @Mapping(target = "DaysTaken", source = "leaveApplicationDTO.DaysTaken"),
            @Mapping(target = "Comment", source = "leaveApplicationDTO.Comment")
    })

    LeaveApplications DTOToEntity(LeaveApplicationDTO leaveApplicationDTO);

    List<LeaveApplicationDTO> map (Iterable<LeaveApplications> leaveApplications);
}
