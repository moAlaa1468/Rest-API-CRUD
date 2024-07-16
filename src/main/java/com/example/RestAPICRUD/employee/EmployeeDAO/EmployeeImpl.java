package com.example.RestAPICRUD.employee.EmployeeDAO;

import com.example.RestAPICRUD.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * What is the purpose of the service class
 * Service class used to collect data from more than DAO class
 * from different DataAccessObjects Like : if you three DAO
 * one for EmployeeDAO , SkillsDAO and PayrollDAO
 * via Single service you could collect data from these three DAOs
 * very simple ===> to pass all data collected from these three DAOs
 * and give the RESTController single view from these three Classes
 * RestController -> service -> DAOClass -> DB
 *
 * When using ===> @Service
 * Spring will automatically register the Service  implementation
 * thanks to component-scanning
 *  هتحتاج انك تعرف ال DAO لل service من خلال ال injection
 *
 *
 * */

@Repository
public class EmployeeImpl implements EmployeeDAO {
    private EntityManager entityManager;

    // we need to autowired this class with EntityManager
    // This is the injection 
    @Autowired
    public EmployeeImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // -------------------- These all the crud operation via EntityManager---------------

    @Override
    public Employee save(Employee employee) {
        // if exist it will update if not it will insert and save
        Employee coming = entityManager.merge(employee);
        return coming;
    }

    @Override
    public void info(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);

    }

    @Override
    public void deleteById(Integer id) {
        // You have the id you need to the object from database
        // then you need to remove this object uaamer
        Employee returnedObject = entityManager.find(Employee.class, id);
        // delete this object
        entityManager.remove(returnedObject);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee); // You could use merge for making update on single employee
    }

    @Override
    public List<Employee> retrievingAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("From Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        System.out.println("This is the complete List of employees");
        return allEmployees;

    }

    @Override

    public List<Employee> findEmployeeByLastName(String theData) {
        return List.of();
    }


    @Override
    public void deleteAllEmployee() {

    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("From Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }


}
