package Lesson_2;

import java.util.Scanner;

public class Calculator {

    private final Scanner scanner = new Scanner(System.in);

    private int readNumber(String message) throws Exception {
        try {
            System.out.printf("%s: ", message);
            int input = scanner.nextInt();
            scanner.nextLine();

            return input;
        } catch (Exception e) {
            throw new Exception("Ошибка: необходимо ввести целое число!");
        }
    }

    private String readOperator() throws Exception {
        System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
        String operator = scanner.nextLine().trim();

        switch (operator) {
            case "+":
                return "+";
            case "-":
                return "-";
            case "*":
                return "*";
            case "/":
                return "/";
            case "^":
                return "^";
            case "%":
                return "%";
            default:
                throw new Exception(operator);
        }
    }

    private Number calculate(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (a == 0) {
                    throw new Exception("Ошибка: деление на ноль запрещено");
                }
                return (double) a / b;
            case "^":
                int result = 1;
                for (int i = 0; i < Math.abs(b); i++) {
                    result *= a;
                }
                if (b < 0) {
                    return (double) 1 / result;
                }
                return result;
            case "%":
                return a % b;
            default:
                throw new Exception("Ошибка: неизвестный оператор");
        }
    }

    private void printResult(Number result, int a, String operator, int b) {
        if (result instanceof Double && result.intValue() == (double) result) {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + result.intValue());
        } else if (result instanceof Integer) {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + result);
        } else {
            System.out.println("Результат: " + a + " " + operator + " " + b + " = " + result);
        }
    }

    private boolean shouldContinue() {
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

    public void run() {
        while (true) {
            System.out.println();
            int a = 0;

            try {
                a = readNumber("Введите первое число");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.close();
                return;
            }

            String operator = "";

            try {
                operator = readOperator();
            } catch (Exception e) {
                System.out.printf("Ошибка: операция %s не поддерживается.%n", e.getMessage());
                System.out.println("Доступны следующие операции: +, -, *, /, ^, %");
                scanner.close();
                return;
            }

            int b = 0;

            try {
                b = readNumber("Введите второе число");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.close();
                return;
            }

            Number result = 0;

            try {
                result = calculate(a, b, operator);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }

            printResult(result, a, operator, b);

            if (shouldContinue()) {
                continue;
            }

            scanner.close();
            return;
        }
    }
}
