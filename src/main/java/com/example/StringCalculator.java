package com.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",";
            if (numbers.startsWith("//")) {
                String[] parts = numbers.split("\n", 2);
                delimiter = parts[0].substring(2);
                numbers = parts[1];
            }

            String[] numArray = numbers.split("[,\n" + delimiter + "]");
            List<Integer> negativeNumbers = new ArrayList<>();

            int sum = 0;
            for (String num : numArray) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negativeNumbers.add(n);
                }
                if (n <= 1000) {
                    sum += n;
                }
            }

            if (!negativeNumbers.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
            }

            return sum;
        }
    }

}





