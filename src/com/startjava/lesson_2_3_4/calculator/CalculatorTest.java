package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    private final static String mainLine = "Хотите продолжить вычисления? [yes / no]: ";
    private final static String alternativeLine = "Введите корректный ответ [yes / no]: ";
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        do {
            System.out.println();

            try {
                System.out.print("Введите математическое выражение: ");
                String input = scanner.nextLine();
                Object[] operatorData = getOperatorData(input.trim().split(""));
                String operator = (String) operatorData[0];
                int operatorIdx = (int) operatorData[1];

                if (operatorIdx == -1) {
                    throw new RuntimeException("Ошибка: введите корректное математическое выражение");
                }

                int a = parseOperand(input.substring(0, operatorIdx).trim());
                int b = parseOperand(input.substring(operatorIdx + 1).trim());
                double result = calculator.calculate(a, b, operator);

                printResult(a, b, operator, result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (shouldContinue());

        scanner.close();
    }

    private static Object[] getOperatorData(String[] data) {
        final String operators = "+-*/^%";
        int idx = -1;
        String operator = "";

        for (int i = 0; i < data.length; i++) {
            if (operators.contains(data[i]) && data[i + 1].equals(" ")) {
                idx = i;
                operator = data[idx];
                break;
            }
        }

        return new Object[]{operator, idx};
    }

    private static int parseOperand(String data) {
        try {
            return Integer.parseInt(data);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка: введите корректное математическое выражение");
        }
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
            System.out.print(isMainMessage ? mainLine : alternativeLine);
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