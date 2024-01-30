package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Add method should return the sum for two numbers separated by a comma")
    void addMethodShouldReturnSumForTwoNumbersSeparatedByComma() {
        int result = StringCalculator.add("1,2");
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Add method should return sum for unknown amount of numbers")
    void addMethodShouldReturnSumForUnknownAmountOfNumbers(){
        int result = StringCalculator.add("1,2,3,4,5");
        assertEquals(15,result);
    }

    @Test
    @DisplayName("Add method should handle new lines between numbers")
    void addMethodShouldHandleNewLinesBetweenNumbers(){
        int result = StringCalculator.add("1\n2,3");
        assertEquals(6, result);
    }
}
