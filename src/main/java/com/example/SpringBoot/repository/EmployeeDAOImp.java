package com.example.SpringBoot.repository;

import com.example.SpringBoot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //From Here ------------------------------------------>

  /*  @Override
    public <S extends Employee> S save(S s) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return null ;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {

    }

    @Override
    public void deleteAll() {

    }
    */


    //-------------------------------->To Here InBuild Methods


    //From Here---------------------------------------------------------------------------->


    @Override
    public List<Employee> findAllEmp() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findEmpById(int theId) {
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "from Employee WHERE id= :theId", Employee.class);
        Employee thEmployees = theQuery.setParameter("theId", theId).getSingleResult();

        if (thEmployees == null) {
            throw new RuntimeException("Not found");
        }

        return thEmployees;
    }

    @Override
    public List<Employee> findAlgetEmployeeab() {
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "from Employee WHERE name Like '%ab%' ",
                Employee.class);

        List<Employee> empTables = theQuery.getResultList();

        return empTables;
    }

    @Override
    public List<Employee> findAlgetEmployeeSalary() {
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "from Employee WHERE salary < 2000 ",
                Employee.class);

        List<Employee> empTables = theQuery.getResultList();

        return empTables;
    }

    @Override
    public void saveEmp(Employee theEmployee) {

        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "INTO Employee (name,age,email,salary) VALUES (:name,:age,:email,:salary)", Employee.class);

        Employee employee = theQuery.setParameter("name",
                theEmployee.getName()).setParameter("age", theEmployee.getAge()).
                setParameter("email", theEmployee.getEmail()).
                setParameter("salary", theEmployee.getSalary())
                .getSingleResult();
    }

    @Override
    public void deleteById(int theId) {

        Query theQuery = entityManager.createQuery(
                "DELETE FROM Employee WHERE id = :theId", Employee.class);
        theQuery.setParameter("theId", theId).executeUpdate();
    }

    @Override
    public List<Employee> findDetails() {
        return null;
    }

    @Override
    public List<String> findDistnict() {
        return null;
    }

    //-------------------------------- To Here JPA function
}
