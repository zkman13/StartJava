package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        do {
            System.out.println();

            try {
                int a = inputOperand("Введите первое число");
                String operator = inputOperator();
                calculator.checkOperator(operator);
                int b = inputOperand("Введите второе число");
                double result = calculator.calculate(a, b, operator);
                printResult(a, b, operator, result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (shouldContinue());

        scanner.close();
    }

    private static int inputOperand(String message) {
        try {
            System.out.printf("%s: ", message);
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка: необходимо ввести целое число");
        }
    }

    private static String inputOperator() {
        System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
        return scanner.nextLine().trim();
    }

    private static boolean shouldContinue() {
        System.out.println();

        while (true) {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true;
            }
            if (input.equals("no")) {
                return false;
            }
        }
    }

    private static void printResult(int a, int b, String operator, double result) {
        if (result == (int) result) {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + (int) result);
        } else {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + result);
        }
    }
}