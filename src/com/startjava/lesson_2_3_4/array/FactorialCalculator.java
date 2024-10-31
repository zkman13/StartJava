package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {

    public static int[] calculate(Integer... numbers) {
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

    public static void printAll(int[] initials, int[] factorials) {
        if (initials == null || factorials == null) {
            System.out.println("Ошибка: Ни один из аргументов не может быть null");
            return;
        }

        int length = initials.length;

        for (int i = 0; i < length; i++) {
            System.out.println(format(initials[i], factorials[i]));
        }
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

    private static String format(int number, int result) {
        if (number == 0) {
            return "0! = 1";
        } else if (number < 0) {
            return String.format("Ошибка: факториал %d! не определен", number);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            sb.append(i).append(i == number ? "" : " * ");
        }

        return String.format("%d! = %s = %d", number, sb.toString(), result);
    }
}
