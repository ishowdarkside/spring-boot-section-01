package com.ishowdarkside.cruddemo.rest;


import com.ishowdarkside.cruddemo.dao.EmployeeDAO;
import com.ishowdarkside.cruddemo.entity.Employee;
import com.ishowdarkside.cruddemo.service.EmployeeService;
import com.ishowdarkside.cruddemo.service.EmployeeServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    // quick and dirty : inject employee dao
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getSingleEmployee(@PathVariable int employeeId){

        Employee employee =  employeeService.findById(employeeId);
        if(employee == null) throw new RuntimeException("Employee id not found - " + employeeId);
        return  employee;
    }

    // add a mapping for POST /employees - add a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return  dbEmployee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;

    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null) throw  new RuntimeException("Employee id not found - " + employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee with id of " + employeeId;

    }

}
