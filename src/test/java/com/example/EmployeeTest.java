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

   @Test
   @DisplayName("setId updates employee id")
    void setIdUpdatesEmployeeId(){
       employee.setId("Ludwig");
       assertThat(employee.getId()).isEqualTo("Ludwig");

   }

   @Test
   @DisplayName("setSalary updates employee salary")
    void setSalaryUpdatesEmployeeSalary(){
       employee.setSalary(75000);
       assertThat(employee.getSalary()).isEqualTo(75000);
   }

    @Test
    @DisplayName("setPaid updates employee paid status")
     void setPaidUpdatesEmployeePaidStatus(){
        employee.setPaid(true);
        assertThat(employee.isPaid()).isTrue();
    }

    @Test
    @DisplayName("toString should return correct format with specific id and salary")
     void toStringShouldReturnCorrectFormatWithSpecificIdAndSalary(){
        String expected = "Employee [id=" + "Svante" + ", salary=" + 50000.0 + "]";
        assertThat(employee.toString()).isEqualTo(expected);

    }



}
