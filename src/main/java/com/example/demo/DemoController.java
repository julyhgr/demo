package com.example.demo;

import com.example.entity.Department;
import com.example.entity.User;
import com.example.repository.DepartmentRepository;
import com.example.repository.UserRepository;
import com.example.service.MySqlTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
public class DemoController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    @RequestMapping("/test")
    String hello() {
        return "hello";
    }

    @RequestMapping("data")
    public Object dataDemo() {
        User user=new User();
        Calendar calendar=Calendar.getInstance();
        user.setCreateDate(calendar.getTime());
        user.setName("testUser");
        Department department=new Department();
        department.setName("testDepartment");
        departmentRepository.save(department);
        user.setDepartment(department);
        userRepository.save(user);
        List<User> all = userRepository.findAll();

        for (User item : all) {
            user.getDepartment();
        }
        return all;
    }
}
