package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",";
            if (numbers.startsWith("//")) {
                int delimiterEnd = numbers.indexOf('\n');
                delimiter = numbers.substring(3, delimiterEnd);
                numbers = numbers.substring(delimiterEnd + 1);
            }

            String[] numArray = numbers.split("[,\n" + Pattern.quote(delimiter) + "]");
            List<Integer> negativeNumbers = new ArrayList<>();
            int sum = 0;

            for (String num : numArray) {
                if (!num.isEmpty()) {
                    int n = Integer.parseInt(num);
                    if (n < 0) {
                        negativeNumbers.add(n);
                    }
                    if (n <= 1000) {
                        sum += n;
                    }
                }
            }

            if (!negativeNumbers.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
            }

            return sum;
        }
    }
}






