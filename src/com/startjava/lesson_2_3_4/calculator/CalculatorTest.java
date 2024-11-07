package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    private final static String MAIN_CONTINUE_INPUT_MSG = "Хотите продолжить вычисления? [yes / no]: ";
    private final static String ALTERNATIVE_CONTINUE_INPUT_MSG = "Введите корректный ответ [yes / no]: ";
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        do {
            System.out.println();

            try {
                System.out.print("Введите математическое выражение: ");
                Object[] calcResult = calculator.start(scanner.nextLine());
                int a = (int) calcResult[0];
                int b = (int) calcResult[1];
                String operator = (String) calcResult[2];
                double result = (double) calcResult[3];

                printResult(a, b, operator, result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (shouldContinue());

        scanner.close();
    }

    private static void printResult(int a, int b, String operator, double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        String resultStr = result == (int) result ? String.valueOf((int) result) : df.format(result);

        System.out.printf("Результат: %d %s %d = %s%n", a, operator, b, resultStr);
    }

    private static boolean shouldContinue() {
        System.out.println();
        boolean isMainMessage = true;

        while (true) {
            System.out.print(isMainMessage ? MAIN_CONTINUE_INPUT_MSG : ALTERNATIVE_CONTINUE_INPUT_MSG);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true;
            }

            if (input.equals("no")) {
                return false;
            }

            isMainMessage = false;
        }
    }
}