package com.example;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else if (numbers.contains(",")){
            String[] numberArray = numbers.split(",");
            int sum = 0;
            for (String num : numberArray){
                sum += Integer.parseInt(num);
            }
            return sum;
        } else{
            return Integer.parseInt(numbers);
        }
    }
}
