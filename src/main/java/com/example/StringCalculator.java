package com.example;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",";
            String[] lines = numbers.split("\n", 2);

            if (lines.length > 1 && lines[0].startsWith("//")) {
                delimiter = lines[0].substring(2);
                numbers = lines[1];
            }

            String[] numArray = numbers.split("[,\n" + delimiter + "]");
            int sum = 0;

            for (String num : numArray) {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                }
            }

            return sum;
        }
    }
}




