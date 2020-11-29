package com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true,  nullable=false)
    private int Id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedDate", length = 19)
    private Date CreatedDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UpdatedDate", length = 19)
    private Date UpdatedDate;
    @Column(name ="IsActive")
    private Boolean IsActive;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }
}

