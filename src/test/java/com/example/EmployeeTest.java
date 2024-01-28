package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EmployeeTest {

    Employee employee;

   @BeforeEach
    void setUpEmployee() {
       employee = new Employee("Svante", 50000.0);
   }

   @Test
   @DisplayName("Verify employee details after creation")
    void verifyEmployeeDetailsAfterCreation(){
       assertThat(employee.getId()).isEqualTo("Svante");
       assertThat(employee.getSalary()).isEqualTo(50000.0);
       assertThat(employee.isPaid()).isTrue();
   }









}
