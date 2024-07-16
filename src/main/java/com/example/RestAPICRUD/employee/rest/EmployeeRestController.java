package com.example.RestAPICRUD.employee.rest;


import com.example.RestAPICRUD.employee.EmployeeDAO.EmployeeDAO;
import com.example.RestAPICRUD.employee.entity.Employee;
import com.example.RestAPICRUD.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * This controller will be used to make the operations related to the database
 * All coming information would in json format and jackson package will convert it
 * jackson will convert from and to POJO classes
 *
 *
 *
 *
 * =========== The most important part here is make employee through the Post method ====
 *             which wil be sent from the client or the browser
 * */
@RestController
@RequestMapping("/")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
        // You have to use Controller injection in order to  inject the employeeDAO to RestController
    EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/emp")
    public String info() {
        return "Hello world ";
    }

    @GetMapping("/what")
    public String printing() {
        return "what is the  wrong on this project ";
    }

//    @GetMapping("/all")
//    public List<Employee> printAll() {
//        // jackson package will solve this problem uaamer this so simple method
//        System.out.println("This is the printAll methods uaAmer");
//        return employeeService.findAll();
//    }

    // we need to make client read the employee according to the id sent in URL
    // You need to use @PathVariable to pass url value to the  function
    @GetMapping("/all/{employee_id}")
    public Employee getSingleEmployee(@PathVariable int employee_id) {
        // But here we need to make some checks
        Employee returnedEmployee = employeeService.findById(employee_id);
        if (returnedEmployee == null) {
            throw new RuntimeException();
        } else {
            return returnedEmployee;
        }
    }

    //insert
    // You would use @PostMapping to insert some values to the database
    @PostMapping("/all")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0L);
        return employeeService.save(theEmployee);
    }

    // update
    // This is step 5 updating an Employee
    @PutMapping("/all")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Delete
    // we need to delete an employee
    @DeleteMapping("/all/{employee_id}")
    public String deleteEmployee(@PathVariable int employee_id) {
        employeeService.deleteById(employee_id);
        return "Deleted ";
    }

    // Read
    // This is the first CRUD operation
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

}
