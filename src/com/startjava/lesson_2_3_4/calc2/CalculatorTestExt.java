package com.startjava.lesson_2_3_4.calc2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTestExt {

    private static final String NO = "no";
    private static final String YES = "yes";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        calculateUntilQuit(console);
        console.close();
    }

    private static void calculateUntilQuit(Scanner console) {
        String option = YES;
        while (!NO.equals(option)) {
            if (YES.equals(option)) {
                String expression = inputExpression(console);
                try {
                    double result = CalculatorExt.calculate(expression);
                    print(expression, result);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            option = console.nextLine().toLowerCase();
        }
    }

    private static String inputExpression(Scanner console) {
        System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
        return console.nextLine().trim().replaceAll("\\s+", " ");
    }

    private static void print(String expression, double result) {
        System.out.println(expression + " = " + (new DecimalFormat("#.###").format(result)));
    }
}