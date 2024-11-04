package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public double calculate(int a, int b, String operator) {
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
                return Math.pow(a, b);
            case "%":
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: попытка выполнить операцию с нулевым делителем");
                }
                return Math.IEEEremainder(a, b);
            default:
                throw new UnsupportedOperationException(String.format("Ошибка: операция %s " +
                        "не поддерживается%nДоступны следующие операции: +, -, *, /, ^, %%", operator));
        }
    }
}
