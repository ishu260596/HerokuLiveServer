package com.example.SpringBoot.service;

import com.example.SpringBoot.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmpService {

    List<Employee> getAll();

    Optional<Employee> findEmpById(int id);

    void save(Employee employee);

    void deleteEmpByID(int id);

    //-------------------------------------------------------------------------------------->

    List<Employee> findAllE();

    Employee findEmpByIdE(int id);

    void saveE(Employee employee);

    void deleteEmpByIDE(int id);

    void deleteAllEmp();

    List<Employee> findAlgetEmployeeab();

    List<Employee> findAlgetEmployeeSalary();

    List<Employee> findDetails();

    List<String> findDistnict();

}
