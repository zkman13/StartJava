import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите левое выражение: ");
        String leftExpression = scanner.nextLine().trim();
        int parsedLeftExpression = 0;

        try {
            parsedLeftExpression = Integer.parseInt(leftExpression);
        } catch (Exception e) {
            System.out.println("Неверное левое выражение. Необходимо ввести целое число!");
            System.exit(0);
        }

        System.out.print("Введите оператор: ");
        String operator = scanner.nextLine().trim();

        if (operator.length() != 1) {
            System.out.println("Неверный оператор. Должен быть одним из + - * / ^ % символов!");
        }

        if (!(operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("*") ||
                operator.equals("/") ||
                operator.equals("^") ||
                operator.equals("%"))) {
            System.out.println("Неверный оператор. Оператор должен быть одним из + - * / ^ % символов!");
            System.exit(0);
        }

        System.out.print("Введите правое выражение: ");
        String rightExpression = scanner.nextLine().trim();
        int parsedRightExpression = 0;

        try {
            parsedRightExpression = Integer.parseInt(rightExpression);
        } catch (Exception e) {
            System.out.println("Неверное правое выражение. Необходимо ввести целое число!");
            System.exit(0);
        }

        scanner.close();
        double result = 0;

        if (operator.equals("+")) {
            result = parsedLeftExpression + parsedRightExpression;
        } else if (operator.equals("-")) {
            result = parsedLeftExpression - parsedRightExpression;
        } else if (operator.equals("*")) {
            result = parsedLeftExpression * parsedRightExpression;
        } else if (operator.equals("/")) {
            if (parsedLeftExpression == 0) {
                System.out.println("На 0 делить нельзя!");
                System.exit(0);
            }

            result = (double) parsedLeftExpression / parsedRightExpression;
        } else if (operator.equals("^")) {
            result = (int) Math.pow(parsedLeftExpression, parsedRightExpression);
        } else if (operator.equals("%")) {
            result = parsedLeftExpression % parsedRightExpression;
        }

        if (Math.abs(result % 1) < 1e-10) {
            System.out.println("Результат: " + parsedLeftExpression + " " + operator + " " +
                    parsedRightExpression + " = " + (int) result);
        } else {
            System.out.println("Результат: " + parsedLeftExpression + " " + operator + " " +
                    parsedRightExpression + " = " + result);
        }
    }
}
