package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.EmployeeService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public  String GetEmployees(Model model)
    {
        model.addAttribute("employeeList", employeeService.GetAll());
        return "employee/index";
    }

    @RequestMapping("/create")
    public String create (Model model)
    {
        EmployeeDTO employee = new EmployeeDTO();
        model.addAttribute("employee",employee);
        return  "employee/create";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") EmployeeDTO employee)
    {
        employeeService.AddOrUpdate(employee);
        return "redirect:/employee/";
    }
}
