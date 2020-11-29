package com.employeeLeaveApplication.zw.employeeLeaveApplication.dto;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.dictionaries.Dictionaries;
import java.util.Date;
public class LeaveApplicationDTO {
    private int EmployeeId;
    private int Id;
    private Dictionaries.LeaveType LeaveType;
    private  Date DateFrom;
    private Date DateTo;
    private  Double DaysTaken;
    private  String Comment;

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Dictionaries.LeaveType getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(Dictionaries.LeaveType leaveType) {
        LeaveType = leaveType;
    }

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        DateFrom = dateFrom;
    }

    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date dateTo) {
        DateTo = dateTo;
    }

    public Double getDaysTaken() {
        return DaysTaken;
    }

    public void setDaysTaken(Double daysTaken) {
        DaysTaken = daysTaken;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
