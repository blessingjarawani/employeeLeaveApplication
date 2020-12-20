package com.employeeLeaveApplication.zw.employeeLeaveApplication.dto;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.dictionaries.Dictionaries;

import java.util.Date;
import java.util.List;


public class EmployeeDTO {

    private int  Id;
    private String FirstName;

    private String LastName;

    private Date DateOfBirth;

    private String EmpCode;

    private Dictionaries.Title Title;

    private Dictionaries.Gender Gender;

    private Integer DepartmentId;

    private  Integer CompanyId;

    private List<LeaveApplicationDTO> LeaveApplications ;

    private DepartmentDTO Department ;

    private  CompanyDTO Company;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmpCode() {
        return EmpCode;
    }

    public void setEmpCode(String empCode) {
        EmpCode = empCode;
    }

    public Dictionaries.Title getTitle() {
        return Title;
    }

    public void setTitle(Dictionaries.Title title) {
        Title = title;
    }

    public Dictionaries.Gender getGender() {
        return Gender;
    }

    public void setGender(Dictionaries.Gender gender) {
        Gender = gender;
    }

    public List<LeaveApplicationDTO> getLeaveApplications() {
        return LeaveApplications;
    }

    public void setLeaveApplications(List<LeaveApplicationDTO> leaveApplications) {
        LeaveApplications = leaveApplications;
    }

    public DepartmentDTO getDepartment() {
        return Department;
    }

    public void setDepartment(DepartmentDTO department) {
        Department = department;
    }

    public CompanyDTO getCompany() {
        return Company;
    }

    public void setCompany(CompanyDTO company) {
        Company = company;
    }

    public Integer getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        DepartmentId = departmentId;
    }

    public Integer getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(Integer companyId) {
        CompanyId = companyId;
    }
}
