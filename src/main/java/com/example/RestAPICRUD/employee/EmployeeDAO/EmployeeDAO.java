package com.example.RestAPICRUD.employee.EmployeeDAO;


import com.example.RestAPICRUD.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee save(Employee student);

    public void info(Employee student);

    public void delete(Employee student);

    public Employee findById(Integer id);

    public List<Employee> findAll();

    public void deleteById(Integer id);

    public void updateEmployee(Employee student);

    public List<Employee> retrievingAllEmployees();

    public List<Employee> findEmployeeByLastName(String theData);

    public String toString();

    public void deleteAllEmployee();

}
