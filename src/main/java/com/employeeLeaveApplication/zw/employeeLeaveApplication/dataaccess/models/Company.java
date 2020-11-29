package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Company")
public class Company extends  BaseEntity  implements Serializable {
    @Column(name ="Name")
    private String Name;
    @OneToMany(mappedBy = "Company")
    private Set<Employees> Employees = new HashSet<>();
    public  Company ()
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Employees> getEmployees() {
        return Employees;
    }

    public void setEmployees(Set<com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Employees> employees) {
        Employees = employees;
    }
}

