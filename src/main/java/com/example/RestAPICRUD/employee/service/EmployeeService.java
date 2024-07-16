package com.example.RestAPICRUD.employee.service;

import com.example.RestAPICRUD.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public List<Employee> findAll();

    public void deleteById(Integer id);

    public Employee save(Employee employee);

    public Employee findById(Integer Id);
}
