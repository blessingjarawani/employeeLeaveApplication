package com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper.DepartmentMapper;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository.DepartmentsRepository;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class DepartmentService {
    private final DepartmentsRepository departmentsRepository;
    @Autowired
    DepartmentMapper Mapper;
    public  DepartmentService(DepartmentsRepository departmentsRepository)
    {
        this.departmentsRepository = departmentsRepository;
    }

    public List<DepartmentDTO> GetAll()
    {
        return Mapper.Map(departmentsRepository.findAll());
    }

    public  DepartmentDTO GetById(Integer id)
    {
        return Mapper.EntityToDTO(departmentsRepository.findById(id).orElse(null));
    }
    public Boolean AddOrUpdate(DepartmentDTO departmentDTO)
    {
        if (departmentDTO !=null)
        {
            Department newDepartment = Mapper.DTOToEntity(departmentDTO);
            Department department = departmentsRepository.findById(newDepartment.getId()).orElse(null);
            if (department==null)
            {
                departmentsRepository.save(department);
                return true;
            }
        }
        return false;
    }
}
