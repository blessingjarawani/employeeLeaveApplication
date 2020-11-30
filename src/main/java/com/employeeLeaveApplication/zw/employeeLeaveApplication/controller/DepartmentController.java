package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
   private DepartmentService departmentService;

    @GetMapping("/")
    public String GetAll(Model model)
    {
        model.addAttribute("departmentList", departmentService.GetAll());
        return "Department/index";
    }
     @RequestMapping("/create")
    public String create (Model model)
   {
    DepartmentDTO department = new DepartmentDTO();
    model.addAttribute("department",department);
    return  "department/create";

  }

  @PostMapping("/save")
 public String save(@ModelAttribute("department") DepartmentDTO department)
  {
      departmentService.AddOrUpdate(department);
      return "redirect:/department/";
  }
}
