package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {

    public static int[] calculate(int... numbers) {
        if (numbers == null) {
            return null;
        }

        int length = numbers.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = factorial(numbers[i]);
        }

        return result;
    }

    private static int factorial(int number) {
        if (number < 0) {
            return -1;
        }

        int total = 1;

        for (int i = 1; i <= number; i++) {
            total *= i;
        }

        return total;
    }
}
