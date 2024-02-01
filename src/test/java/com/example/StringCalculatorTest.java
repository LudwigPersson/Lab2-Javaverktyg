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

    @Test
    @DisplayName("Add method should support custom delimiter")
    void addMethodShouldSupportCustomDelimiter(){
        int result = StringCalculator.add("//;\n1;2");
        assertEquals(3,result);

    }

    @Test
    @DisplayName("Add method should throw exception for negative numbers")
    void addMethodShouldThrowExceptionForNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1,-2,3,-4"));

        assertEquals("Negatives not allowed: [-2, -4]", exception.getMessage());
    }

    @Test
    @DisplayName("Add method should ignore numbers greater than 1000")
    void addMethodShouldIgnoreNumbersGreaterThan1000(){
        int result = StringCalculator.add("2,1001");
        assertEquals(2,result);

    }

    @Test
    @DisplayName("Add method should handle custom delimiter of any length")
    void addMethodShouldHandleCustomDelimiterOfAnyLength() {
        int result = StringCalculator.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Add method should handle multiple delimiters")
    void addMethodShouldHandleMultipleDelimiters() {
        int result = StringCalculator.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Add method should handle multiple delimiters with length longer than one char")
    void addMethodShouldHandleMultipleDelimitersWithLengthLongerThanOneChar() {
        int result = StringCalculator.add("//[***][%%%]\n1***2%%%3");
        assertEquals(6, result);
    }
}
