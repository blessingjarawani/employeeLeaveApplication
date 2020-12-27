package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.CompanyService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.EmployeeService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.EmployeeDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.utl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private  final Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
    @GetMapping("/")
    public  String GetEmployees(Model model)
    {
    try
     {
        model.addAttribute("employeeList", employeeService.GetAll());
         logger.info("Get Employee List Pass");
         return "employee/index";
    } catch (Throwable ex)
    {
        logger.error(ex.getMessage());
        return "error/error";
    }
    }

    @RequestMapping("/create")
    public String create (Model model)
    {
        try
        {
        EmployeeDTO employee = new EmployeeDTO();
        model.addAttribute("departmentList", departmentService.GetAll());
        model.addAttribute("companyList", companyService.GetAll());
        model.addAttribute("employee",employee);
        return  "employee/create";
    } catch (Throwable ex)
    {
        logger.error(ex.getMessage());
        return "error/error";
    }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") EmployeeDTO employee)
    {
        try {
            employeeService.AddOrUpdate(employee);
            logger.info("Added/updated Employee "+ employee.getEmpCode());
            return "redirect:/employee/";
        } catch (Throwable ex)
        {
            logger.error(ex.getMessage());
            return  "error/error";
        }
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id,Model model) {
        try {
            EmployeeDTO employee = employeeService.GetById(id);
            if (employee != null) {
                model.addAttribute(
                        "employee", employee
                );
                model.addAttribute(
                        "companyList",
                        companyService.GetAll());
                model.addAttribute(
                        "departmentList",
                        departmentService.GetAll());
                logger.info("Edited Employee "+ id);
                return "employee/edit";
            }
            throw  new NotFoundException("Employee Not Found");
        }
        catch (NotFoundException ex)
        {
            logger.warn(ex.getMessage());
            return "error/not_found";
        } catch (Throwable ex)
        {
            logger.error(ex.getMessage());
            return  "error/error";
        }
    }

    @RequestMapping("/delete/{id}")
    public String DeleteEmployee(@PathVariable(name = "id") int id) {
        try {
            employeeService.DeleteById(id);
            logger.info("Deleted Employee "+ id);
            return "redirect:/employee/";
        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            return  "error/error";
        }
    }
}
