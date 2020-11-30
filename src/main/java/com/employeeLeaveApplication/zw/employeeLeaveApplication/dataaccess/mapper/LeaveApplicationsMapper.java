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
       // @Mapping(target = "employeeId", source = "entity.employeeId"),
        @Mapping(target = "id", source = "entity.id"),
        @Mapping(target = "leaveType", source = "entity.leaveType"),
        @Mapping(target = "dateFrom", source = "entity.dateFrom"),
        @Mapping(target = "dateTo", source = "entity.dateTo"),
        @Mapping(target = "daysTaken", source = "entity.daysTaken"),
        @Mapping(target = "comment", source = "entity.comment")
})
    LeaveApplicationDTO EntityToDTO(LeaveApplications entity);

    @Mappings({
            //@Mapping(target = "employeeId", source = "leaveApplicationDTO.employeeId"),
            @Mapping(target = "id", source = "leaveApplicationDTO.id"),
            @Mapping(target = "leaveType", source = "leaveApplicationDTO.leaveType"),
            @Mapping(target = "dateFrom", source = "leaveApplicationDTO.dateFrom"),
            @Mapping(target = "dateTo", source = "leaveApplicationDTO.dateTo"),
            @Mapping(target = "daysTaken", source = "leaveApplicationDTO.daysTaken"),
            @Mapping(target = "comment", source = "leaveApplicationDTO.comment")
    })

    LeaveApplications DTOToEntity(LeaveApplicationDTO leaveApplicationDTO);

    List<LeaveApplicationDTO> map (Iterable<LeaveApplications> leaveApplications);
}
