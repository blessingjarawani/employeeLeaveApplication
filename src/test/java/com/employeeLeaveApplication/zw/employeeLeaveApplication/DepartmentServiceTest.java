package com.employeeLeaveApplication.zw.employeeLeaveApplication;

import com.employeeLeaveApplication.zw.employeeLeaveApplication.bll.services.DepartmentService;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.models.Department;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dataaccess.repository.DepartmentsRepository;
import com.employeeLeaveApplication.zw.employeeLeaveApplication.dto.DepartmentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentsRepository departmentsRepository;

    @Test
    void listAll_whenNotEmpty()
    {
        Department department = new Department();
        department.setName("IT");
        department.setActive(true);
        department.setCreatedDate(new Date());
        Department department2 = new Department();
        department2.setName("Accounting");
        department2.setActive(true);
        department2.setCreatedDate(new Date());
        Department department3 = new Department();
        department2.setName("HRMS");
        department2.setActive(true);
        department2.setCreatedDate(new Date());
        doReturn(Arrays.asList(department,department2,department3))
                .when(departmentsRepository).findAll();
        Iterable<Department> departments = departmentsRepository.findAll();
        Assertions.assertEquals(3, StreamSupport.stream(departments.spliterator(),false).count());
    }

    @Test
    void find_department_whenExists()
    {
        Department department = new Department();
        department.setId(2);
        department.setName("Accounting");
        department.setActive(true);
        department.setCreatedDate(new Date());
        doReturn(Optional.of(department)).when(departmentsRepository).findById(2);
        DepartmentDTO departmentResult = departmentService.GetById(2);
        Assertions.assertTrue((departmentResult != null) );
        Assertions.assertSame(departmentResult.getName(), department.getName());
    }

    @Test
    void find_whenNotFound()
    {
        doReturn(Optional.empty()).when(departmentsRepository).findById(1);
        DepartmentDTO department = departmentService.GetById(90);
        Assertions.assertTrue((department== null));
    }
}
