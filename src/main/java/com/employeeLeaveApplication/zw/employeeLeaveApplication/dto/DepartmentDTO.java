package com.employeeLeaveApplication.zw.employeeLeaveApplication.dto;

import javax.validation.constraints.NotEmpty;

public class DepartmentDTO {
    private int Id;
    @NotEmpty(message = "Department Name cannot be Empty")
    private String Name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
