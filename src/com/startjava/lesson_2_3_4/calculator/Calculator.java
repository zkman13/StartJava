package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public Object[] parseExpression(String expression) {
        Object[] operatorData = getOperatorData(expression.trim().split(""));
        String operator = (String) operatorData[0];
        int operatorIdx = (int) operatorData[1];

        if (operatorIdx == -1) {
            throw new RuntimeException("Ошибка: введите корректное математическое выражение");
        }

        int a = parseOperand(expression.substring(0, operatorIdx).trim());
        int b = parseOperand(expression.substring(operatorIdx + 1).trim());

        return new Object[]{a, b, operator};
    }

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
}
