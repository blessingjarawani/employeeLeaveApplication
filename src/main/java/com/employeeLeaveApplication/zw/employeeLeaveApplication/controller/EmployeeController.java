package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.CompanyService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.EmployeeService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
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
        model.addAttribute("departmentList", departmentService.GetAll());
        model.addAttribute("companyList", companyService.GetAll());
        model.addAttribute("employee",employee);
        return  "employee/create";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") EmployeeDTO employee)
    {
        employeeService.AddOrUpdate(employee);
        return "redirect:/employee/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject(
                "employee",
                employeeService.GetById(id));
        modelAndView.addObject(
                "companyList",
                companyService.GetAll());
        modelAndView.addObject(
                "departmentList",
                departmentService.GetAll());
        return modelAndView;
    }
}
