package com.example.SpringBoot.controller;

import com.example.SpringBoot.entity.Employee;
import com.example.SpringBoot.repository.EmployeeDAO;
import com.example.SpringBoot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmpService empService;

    @Autowired
    public EmployeeController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/employee")
    public List<Employee> findAllEmp() {
        //return empService.getAll();
        return empService.findAllE();

    }

    @GetMapping("/employee/{empId}")
    public Optional<Employee> findEmpById(@PathVariable("empId") int empId) {
        return empService.findEmpById(empId);
        //return empService.findEmpByIdE(empId);
    }

    @PostMapping("/employee/save")
    public void saveEmp(@RequestBody Employee employee) {
        empService.save(employee);
        //empService.saveE(employee);
    }

    @DeleteMapping("/employee/delete/{empId}")
    public void deleteEmpById(@PathVariable("empId") int empId) {
        empService.deleteEmpByID(empId);
        //  empService.deleteEmpByIDE(empId);
    }

}
