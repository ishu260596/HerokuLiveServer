package com.example.SpringBoot.service;

import com.example.SpringBoot.entity.Employee;
import com.example.SpringBoot.repository.EmployeeDAO;
import com.example.SpringBoot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeDAO employeeDAO;


    @Override
    @Transactional
    public List<Employee> getAll() {

        List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
        return employeeList;
    }

    @Override
    @Transactional
    public Optional<Employee> findEmpById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {

        employeeRepo.save(new Employee(employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getSalary()));
    }

    @Override
    @Transactional
    public void deleteEmpByID(int id) {
        employeeRepo.deleteById(id);
    }


    //------------------------------------------------------------>

    @Override
    @Transactional
    public List<Employee> findAllE() {
        return employeeDAO.findAllEmp();
    }

    @Override
    @Transactional
    public Employee findEmpByIdE(int id) {
        return employeeDAO.findEmpById(id);
    }

    @Override
    @Transactional
    public void saveE(Employee employee) {
        employeeDAO.saveEmp(employee);
    }

    @Override
    @Transactional
    public void deleteEmpByIDE(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public void deleteAllEmp() {
        employeeRepo.deleteAll();
    }

    @Override
    @Transactional
    public List<Employee> findAlgetEmployeeab() {
        return employeeDAO.findAlgetEmployeeab();
    }

    @Override
    @Transactional
    public List<Employee> findAlgetEmployeeSalary() {
        return employeeDAO.findAlgetEmployeeSalary();
    }

    @Override
    @Transactional
    public List<Employee> findDetails() {
        return null;
    }

    @Override
    @Transactional
    public List<String> findDistnict() {
        return null;
    }
}
