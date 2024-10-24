package Lesson_2;

import Lesson_2.exeptions.DivisionByZeroException;

public class Calculator {

    public void checkOperator(String operator) throws RuntimeException {
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
            case "%":
                return;
            default:
                throw new UnsupportedOperationException(String.format("Ошибка: операция %s " +
                        "не поддерживается%nДоступны следующие операции: +, -, *, /, ^, %%", operator));
        }
    }

    public double calculate(int a, int b, String operator) throws RuntimeException {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (a == 0) {
                    throw new DivisionByZeroException("Ошибка: деление на ноль запрещено");
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
                throw new RuntimeException("Ошибка: неизвестный оператор");
        }
    }
}
