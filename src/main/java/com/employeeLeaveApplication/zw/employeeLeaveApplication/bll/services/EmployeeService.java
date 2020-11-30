package com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper.EmployeeMapper;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Employees;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository.EmployeeRepository;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper mapper;
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }
    public List<EmployeeDTO> GetAll()
    {
        return mapper.Map(employeeRepository.findAll());
    }

    public EmployeeDTO GetbyId(Integer id)
    {
        return  mapper.EntityToDTO(employeeRepository.findById(id).orElse(null));
    }

    public Boolean AddOrUpdate(EmployeeDTO employeeDTO)
    {
        if (employeeDTO !=null)
        {
            Employees newEmployee = mapper.DTOToEntity(employeeDTO);
            Employees employee = employeeRepository.findById(newEmployee.getId()).orElse(null);
            if (employee==null)
            {
                employeeRepository.save(employee);
                return true;
            }
        }
        return false;
    }
}
