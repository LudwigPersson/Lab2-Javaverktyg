package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositorySpy implements EmployeeRepository {

    public List<Employee> findAllResult;

    public EmployeeRepositorySpy(List<Employee> findAllResult) {
        this.findAllResult = findAllResult;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(findAllResult);
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }

}

