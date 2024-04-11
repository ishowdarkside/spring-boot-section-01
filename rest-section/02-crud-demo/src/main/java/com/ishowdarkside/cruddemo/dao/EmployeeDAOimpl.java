package com.ishowdarkside.cruddemo.dao;

import com.ishowdarkside.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOimpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        //execute query and get result list
        List<Employee> list = theQuery.getResultList();

        // return the results
        return  list;

    }

    @Override
    public Employee findById(int theId) {
        Employee employee = this.entityManager.find(Employee.class,theId);
       // if(employee == null) throw new RuntimeException("Employee not found - " + theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = this.entityManager.merge(theEmployee);
        return  employee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = this.findById(theId);

        entityManager.remove(employee);
    }
}
