package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
 import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {


    @Test
    @DisplayName("Add method should return 0 for an empty string")
    void addMethodShouldReturn0ForAnEmptyString(){
        int result = StringCalculator.add("");
        assertEquals(0,result);

    }

    @Test
    @DisplayName("Add method should return number for single number")
    void addMethodShouldReturnNumberForSingleNumber(){
        int result = StringCalculator.add("1");
        assertEquals(1,result);

    }


}
