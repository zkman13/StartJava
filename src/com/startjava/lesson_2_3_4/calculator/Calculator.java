package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class Calculator {

    public Object[] start(String expression) {
        Object[] expressionParts = parseExpression(expression);
        int a = (int) expressionParts[0];
        int b = (int) expressionParts[1];
        String operator = (String) expressionParts[2];
        double result = calculate(a, b, operator);

        return new Object[]{a, b, operator, result};
    }

    private Object[] parseExpression(String expression) {
        Object[] parts = getOperatorData(expression.trim().split(""));
        String operator = (String) parts[0];
        int operatorIdx = (int) parts[1];

        if (operatorIdx == -1) {
            throw new RuntimeException("Ошибка: введите корректное математическое выражение");
        }

        int a = parseOperand(expression.substring(0, operatorIdx).trim());
        int b = parseOperand(expression.substring(operatorIdx + 1).trim());

        return new Object[]{a, b, operator};
    }

    private double calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (a == 0) {
                    throw new DivisionByZeroException("Ошибка: деление на ноль запрещено");
                }
                yield (double) a / b;
            }
            case "^" -> Math.pow(a, b);
            case "%" -> {
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: попытка выполнить операцию с нулевым делителем");
                }
                yield Math.IEEEremainder(a, b);
            }
            default -> throw new UnsupportedOperationException(String.format("Ошибка: операция %s " +
                    "не поддерживается%nДоступны следующие операции: +, -, *, /, ^, %%", operator));
        };
    }

    private static Object[] getOperatorData(String[] expression) {
        final String operators = "+-*/^%";
        int idx = -1;
        String operator = "";

        for (int i = 0; i < expression.length; i++) {
            if (operators.contains(expression[i]) && expression[i + 1].equals(" ")) {
                idx = i;
                operator = expression[idx];
                break;
            }
        }

        return new Object[]{operator, idx};
    }

    private static int parseOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (Exception e) {
           throw new NumberFormatException("Ошибка: введите корректное математическое выражение");
        }
    }
}
