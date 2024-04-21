package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // add mapping for /list
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // get the employees from db
        List<Employee> employees =  employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees",employees);

        return "employees/list-employees";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        // create model attribute to bind form data
        Employee employee  = new Employee();
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        this.employeeService.save(employee);
        return "redirect:/employees/list";
    }


    @GetMapping("/edit")
    public String editEmployee(@RequestParam("id") int id,Model model){
        Employee employee = this.employeeService.findById(id);

        model.addAttribute("employee",employee);

        return "employees/employee-form";

    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int id){

        this.employeeService.deleteById(id);
        // delete the employee
        return "redirect:/employees/list";

    };
}
