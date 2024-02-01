package com.example;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;


public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String[] numArray;

        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//\\[?(.*?)?\n").matcher(numbers);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = numbers.substring(matcher.end());
            }
        }

        numArray = numbers.split("[,\n" + delimiter + "]");

        List<Integer> negativeNumbers = new ArrayList<>();

        int sum = 0;
        for (String num : numArray) {
            if (!num.isEmpty()) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negativeNumbers.add(n);
                } else if (n <= 1000) {
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












