package com.startjava.lesson_1.final_;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = 0;

        try {
            a = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Необходимо ввести целое число!");
            scanner.close();
            return;
        }

        System.out.print("Введите оператор: ");
        String operator = scanner.nextLine().trim();

        if (!(operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("*") ||
                operator.equals("/") ||
                operator.equals("^") ||
                operator.equals("%"))) {
            System.out.println("Неверный оператор. Оператор должен быть одним из + - * / ^ % символов!");
            scanner.close();
            return;
        }

        System.out.print("Введите второе число: ");
        int b = 0;

        try {
            b = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Необходимо ввести целое число!");
            scanner.close();
            return;
        }

        scanner.close();
        double result = 0;

        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("-")) {
            result = a - b;
        } else if (operator.equals("*")) {
            result = a * b;
        } else if (operator.equals("/")) {
            if (a == 0) {
                System.out.println("На 0 делить нельзя!");
                return;
            }

            result = (double) a / b;
        } else if (operator.equals("^")) {
            result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        } else if (operator.equals("%")) {
            result = a % b;
        }

        if (result == (int) result) {
            System.out.println("Результат: " + a + " " + operator + " " +
                    b + " = " + (int) result);
        } else {
            System.out.println("Результат: " + a + " " + operator + " " +
                    b + " = " + result);
        }
    }
}
