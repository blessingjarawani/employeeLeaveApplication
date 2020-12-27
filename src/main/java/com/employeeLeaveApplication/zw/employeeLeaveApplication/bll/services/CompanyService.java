package com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.mapper.CompanyMapper;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Company;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository.CompanyRepository;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.CompanyDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;
   @Autowired
    CompanyMapper Mapper;
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public List<CompanyDTO> GetAll()
    {
        return Mapper.Map(companyRepository.findAll());
    }

    public  CompanyDTO GetById(Integer id)
    {
        return Mapper.EntityToDTO(companyRepository.findById(id).orElse(null));
    }
    public Boolean AddOrUpdate(CompanyDTO companyDTO)
    {
        if (companyDTO !=null)
        {
            Company newCompany = Mapper.DTOToEntity(companyDTO);
            Company company = companyRepository.findById(newCompany.getId()).orElse(null);
            if (company!=null)
            {
               newCompany.setUpdatedDate(new Date());
            }
            else
            {
                newCompany.setActive(true);
                newCompany.setCreatedDate(new Date());
            }
            companyRepository.save(newCompany);
            return true;
        }
        return false;
    }

}
