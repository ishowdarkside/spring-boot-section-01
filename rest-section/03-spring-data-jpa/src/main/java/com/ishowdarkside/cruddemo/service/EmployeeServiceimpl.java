package com.ishowdarkside.cruddemo.service;

import com.ishowdarkside.cruddemo.dao.EmployeeRepository;
import com.ishowdarkside.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService{

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceimpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }


    @Override
    public Employee findById(int theId) {
        Optional<Employee> employee = this.employeeRepository.findById(theId);
        if(!employee.isPresent()) throw new RuntimeException("Employee with id " + theId + " not found!");
        return employee.get();
    }

    @Override
    public Employee save(Employee theEmployee) {
        return  employeeRepository.save(theEmployee);
    }

    @Override

    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
