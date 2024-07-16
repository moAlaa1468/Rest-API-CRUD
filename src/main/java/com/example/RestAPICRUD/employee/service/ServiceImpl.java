package com.example.RestAPICRUD.employee.service;

import com.example.RestAPICRUD.employee.EmployeeDAO.EmployeeDAO;
import com.example.RestAPICRUD.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/*
 *------------------- This is the service layer --------------------
 * You may have more than DAO package for a lot of different Entities
 * but you will need to make single service interface and its implementation
 * to use all different DAO packages for different entities
 *
 * ---------- The best benefit here is shift the @Transaction to Service layer -------
 * ---------- You would make simple delegation ===> This Service class will be delegated to call other DAO
 * ---------- And it used the Transactional Annotation --------------
 * ------------------------------------------------------------------
 * */


// This is the Service layer Great Layer uaAlaa
@Service
public class ServiceImpl implements EmployeeService {
    // You need to create some properties
    EmployeeDAO employeeDAO;

    // very important hint Donn't use the empty constructor here never You will get great Error
// You need to make binding makes
    // this is the injection process uaAlaa
    public ServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.retrievingAllEmployees();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findById(id);
    }

}
