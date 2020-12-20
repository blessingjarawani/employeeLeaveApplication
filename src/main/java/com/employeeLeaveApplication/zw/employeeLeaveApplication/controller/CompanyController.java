package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.CompanyService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.CompanyDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String GetAll(Model model)
    {
        model.addAttribute("companyList", companyService.GetAll());
        return "company/index";
    }
    @RequestMapping("/create")
    public String create (Model model)
    {
        CompanyDTO company = new CompanyDTO();
        model.addAttribute("company",company);
        return  "company/create";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("company") CompanyDTO company)
    {
        companyService.AddOrUpdate(company);
        return "redirect:/company/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("company/edit");
        modelAndView.addObject(
                "company",
                companyService.GetById(id));
        return modelAndView;
    }
}
