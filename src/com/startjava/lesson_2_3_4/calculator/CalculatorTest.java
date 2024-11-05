package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    private final static String MAIN_MESSAGE = "Хотите продолжить вычисления? [yes / no]: ";
    private final static String ALTERNATIVE_MESSAGE = "Введите корректный ответ [yes / no]: ";
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        do {
            System.out.println();

            try {
                System.out.print("Введите математическое выражение: ");
                Object[] expressionParts = calculator.parseExpression(scanner.nextLine());
                int a = (int) expressionParts[0];
                int b = (int) expressionParts[1];
                String operator = (String) expressionParts[2];
                double result = calculator.calculate(a, b, operator);
                printResult(a, b, operator, result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (shouldContinue());

        scanner.close();
    }

    private static void printResult(int a, int b, String operator, double result) {
        DecimalFormat df = new DecimalFormat("#.###");

        if (result == (int) result) {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + (int) result);
        } else {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + df.format(result));
        }
    }

    private static boolean shouldContinue() {
        System.out.println();
        boolean isMainMessage = true;

        while (true) {
            System.out.print(isMainMessage ? MAIN_MESSAGE : ALTERNATIVE_MESSAGE);
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