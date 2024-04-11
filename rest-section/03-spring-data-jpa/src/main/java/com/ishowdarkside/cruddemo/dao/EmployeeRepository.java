package com.ishowdarkside.cruddemo.dao;

import com.ishowdarkside.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

};
