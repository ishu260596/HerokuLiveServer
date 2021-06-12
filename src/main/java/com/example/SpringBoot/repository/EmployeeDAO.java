package com.example.SpringBoot.repository;

import com.example.SpringBoot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmp();

    Employee findEmpById(int id);

    void saveEmp(Employee employee);

    void deleteById(int id);

    List<Employee> findAlgetEmployeeab();

    List<Employee> findAlgetEmployeeSalary();

    List<Employee> findDetails();

    List<String> findDistnict();


}
