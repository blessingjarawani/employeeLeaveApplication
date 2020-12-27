package com.employeeLeaveApplication.zw.employeeLeaveApplication.controller;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {
    private  final Logger logger= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
   private DepartmentService departmentService;

    @GetMapping("/")
    public String GetAll(Model model)
    {
        try{
        model.addAttribute("departmentList", departmentService.GetAll());
        return "Department/index";
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
    DepartmentDTO department = new DepartmentDTO();
    model.addAttribute("department",department);
    return  "department/create";
   } catch (Throwable ex)
    {
        logger.error(ex.getMessage());
        return "error/error";
    }

  }

  @PostMapping("/save")
 public String save(@ModelAttribute("department") DepartmentDTO department)
  {
      try {
          departmentService.AddOrUpdate(department);
          return "redirect:/department/";
      } catch (Throwable ex)
      {
          logger.error(ex.getMessage());
          return "error/error";
      }
  }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id,Model model) {
        try {
            DepartmentDTO department =  departmentService.GetById(id);
            if (department!= null) {
                model.addAttribute(
                        "department", department
                );
                logger.info("Edited Department "+ id);
                return "department/edit";
            }
            throw  new NotFoundException("Department not Found");
        } catch (NotFoundException ex)
        {
            logger.warn(ex.getMessage());
            return "error/not_found";
        } catch (Throwable ex)
        {
            logger.error(ex.getMessage());
            return "error/error";
        }
    }
}
