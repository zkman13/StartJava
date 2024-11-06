package com.startjava.lesson_2_3_4.calc2;

public class CalculatorExt {

    private static final int ARGS_LIMIT = 3;

    // Suppresses default constructor, ensuring non-instantiability.
    private CalculatorExt() {
        throw new AssertionError("This is a utility class and cannot be instantiated");
    }

    public static double calculate(String expression) {
        String[] args = expression.split(" ");
        checkLimit(args.length);
        int a = parseNum(args[0]);
        int b = parseNum(args[2]);
        char sign = args[1].charAt(0);

        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/', '%' -> divOrMod(a, sign, b);
            case '^' -> Math.pow(a, b);
            default -> throw new RuntimeException("Ошибка: операция \"" + sign + "\" " + "не поддерживается." +
                    " Доступны следующие операции: +, -, *, /, ^, %");
        };
    }

    private static void checkLimit(int length) {
        if (length != ARGS_LIMIT) {
            throw new RuntimeException("Ошибка: количество элементов выражения должно быть три");
        }
    }

    private static int parseNum(String num) {
        try {
            return Integer.parseInt(num);
        } catch (RuntimeException e) {
            throw new RuntimeException("Ошибка: числа в выражении должно быть целыми!");
        }
    }

    private static double divOrMod(int a, char sign, int b) {
        if (b == 0) {
            throw new RuntimeException("Ошибка: деление на ноль запрещено");
        }
        return sign == '/' ? (double) a / b : Math.floorMod(a, b);
    }
}