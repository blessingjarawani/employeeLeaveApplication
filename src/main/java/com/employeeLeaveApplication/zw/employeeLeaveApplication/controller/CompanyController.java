package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.CompanyService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.CompanyDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.utl.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private  final Logger logger= LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String GetAll(Model model)
    {
        try{
        model.addAttribute("companyList", companyService.GetAll());
        return "company/index";
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
        CompanyDTO company = new CompanyDTO();
        model.addAttribute("company",company);
        return  "company/create";
    } catch (Throwable ex)
    {
        logger.error(ex.getMessage());
        return "error/error";
    }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("company") CompanyDTO company)
    {
        try
        {
        companyService.AddOrUpdate(company);
        return "redirect:/company/";
    } catch (Throwable ex)
    {
        logger.error(ex.getMessage());
        return "error/error";
    }
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        try {
            CompanyDTO company = companyService.GetById(id);
            if (company != null) {
                model.addAttribute(
                        "company", company
                );
                return "company/edit";
            }
            throw new NotFoundException("Company Not Found");
        } catch (NotFoundException ex)
        {
            logger.warn(ex.getMessage());
            return "error/not_found";
        }
        catch (Throwable ex)
        {
            logger.error(ex.getMessage());
            return "error/error";
        }

    }
}
