package Lesson_2;

import java.util.Scanner;

public class CalculatorTest {

    private final static Scanner scanner = new Scanner(System.in);

    private static int inputOperand(String message) throws RuntimeException {
        try {
            System.out.printf("%s: ", message);
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка: необходимо ввести целое число");
        }
    }

    private static String inputOperator() throws RuntimeException {
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
            } else if (input.equals("no")) {
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

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        do {
            System.out.println();

            try {
                int a = CalculatorTest.inputOperand("Введите первое число");
                String operator = CalculatorTest.inputOperator();
                calculator.checkOperator(operator);
                int b = CalculatorTest.inputOperand("Введите второе число");
                double result = calculator.calculate(a, b, operator);
                CalculatorTest.printResult(a, b, operator, result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (CalculatorTest.shouldContinue());

        scanner.close();
    }
}