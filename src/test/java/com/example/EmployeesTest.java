package com.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class EmployeesTest {

    EmployeeRepositorySpy employeeRepositorySpy;
    BankServiceStub bankServiceStub;
    Employees employees;

    @BeforeEach
    void setUp() {
        employeeRepositorySpy = new EmployeeRepositorySpy(List.of(new Employee("1", 50000.0)));
        bankServiceStub = new BankServiceStub(true);
        employees = new Employees(employeeRepositorySpy, bankServiceStub);
    }

    @Test
    @DisplayName("Employees receive successful payments using Spy")
    void employeesReceiveSuccessfulPaymentsUsingSpy() {
        int payments = employees.payEmployees();
        assertTrue(payments > 0);

        for (Employee employee : employeeRepositorySpy.findAll()) {
            assertTrue(employee.isPaid());
        }
    }

    @Test
    @DisplayName("Employees receive successful payments using Stub")
    void employeesReceiveSuccessfulPaymentsUsingStub() {
        bankServiceStub.setPaymentResult(true);

        int payments = employees.payEmployees();
        assertTrue(payments > 0);

        for (Employee employee : employeeRepositorySpy.findAll()) {
            assertTrue(employee.isPaid());
        }
    }

    @Test
    @DisplayName("Employees handle payments with different employees and amounts")
    void employeesHandlePaymentsWithDifferentEmployeesAndAmounts() {
        List<Employee> employeesList = Arrays.asList(
                new Employee("1", 50000.0),
                new Employee("2", 60000.0),
                new Employee("3", 75000.0)
        );

        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy(employeesList);
        BankService bankServiceStub = new BankServiceStub(true);
        Employees employees = new Employees(employeeRepositorySpy, bankServiceStub);

        int payments = employees.payEmployees();

        assertEquals(3, payments);

        for (Employee employee : employeeRepositorySpy.findAll()) {
            assertTrue(employee.isPaid());
        }
    }

    @Test
    @DisplayName("Employees handle payments when no employees exist")
    void employeesHandlePaymentsWhenNoEmployeesExist() {
        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy(Collections.emptyList());
        BankService bankServiceStub = new BankServiceStub(true);
        Employees employees = new Employees(employeeRepositorySpy, bankServiceStub);

        int payments = employees.payEmployees();

        assertEquals(0, payments);

        List<Employee> foundEmployees = employeeRepositorySpy.findAll();
        assertTrue(foundEmployees.isEmpty());
    }

}
