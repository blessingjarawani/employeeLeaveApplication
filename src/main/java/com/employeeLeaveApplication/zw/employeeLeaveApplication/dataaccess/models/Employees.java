package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.dictionaries.Dictionaries;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employees")
public class Employees extends  BaseEntity implements Serializable {
    @Column(name = "FirstName")
    private String FirstName;
    @Column(name = "LastName")
    private String LastName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateOfBirth", length = 19)
    private Date DateOfBirth;
    @Column(name = "EmpCode", unique = true, nullable = false)
    private String EmpCode;
    @Column(name = "Title")
    private Dictionaries.Title Title;
    @Column(name = "Gender")
    private Dictionaries.Gender Gender;
    @OneToMany(mappedBy = "Employees")
    private Set<LeaveApplications> LeaveApplication = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "DepartmentId")
    private Department Department;
    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private  Company Company;
    public  Employees()
    {

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


    public com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department getDepartment() {
        return Department;
    }

    public void setDepartment(com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department department) {
        Department = department;
    }

    public com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Company getCompany() {
        return Company;
    }

    public void setCompany(com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Company company) {
        Company = company;
    }

    public Set<LeaveApplications> getLeaveApplication() {
        return LeaveApplication;
    }

    public void setLeaveApplication(Set<LeaveApplications> leaveApplication) {
        LeaveApplication = leaveApplication;
    }
}
