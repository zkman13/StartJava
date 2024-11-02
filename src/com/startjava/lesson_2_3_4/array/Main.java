package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n1. Реверс значений массива\n");

        int[] numbersToReverse = null;
        int[] reversedNumbers = Reverser.reverse(null);
        System.out.printf("До реверса: %s%n", Arrays.toString(numbersToReverse));
        System.out.printf("После реверса: %s%n%n", Arrays.toString(reversedNumbers));

        numbersToReverse = new int[]{6, 8, 9, 1};
        reversedNumbers = Reverser.reverse(numbersToReverse);
        System.out.printf("До реверса: %s%n", Arrays.toString(numbersToReverse));
        System.out.printf("После реверса: %s%n%n", Arrays.toString(reversedNumbers));

        numbersToReverse = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedNumbers = Reverser.reverse(numbersToReverse);
        System.out.printf("До реверса: %s%n", Arrays.toString(numbersToReverse));
        System.out.printf("После реверса: %s%n", Arrays.toString(reversedNumbers));

        System.out.println("\n2. Вычисление факториала\n");

        int[] factorialNumbers = new int[0];
        int[] factorialValues = FactorialCalculator.calculate(factorialNumbers);
        printFactorials(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = null;
        factorialValues = FactorialCalculator.calculate((int[]) null);
        printFactorials(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = new int[]{8, 0, 9};
        factorialValues = FactorialCalculator.calculate(8, 0, 9);
        printFactorials(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = new int[]{-3, 1, 7, 13};
        factorialValues = FactorialCalculator.calculate(-3, 1, 7, 13);
        printFactorials(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = new int[]{-22, -0};
        factorialValues = FactorialCalculator.calculate(-22, -0);
        printFactorials(factorialNumbers, factorialValues);

        System.out.println("\n3. Удаление элементов массива, превышающих заданное значение\n");

        Nullifier.nullify(-1);
        System.out.println();
        Nullifier.nullify(15);
        System.out.println();
        Nullifier.nullify(0);
        System.out.println();
        Nullifier.nullify(14);

        System.out.println("\n4. Вывод отсортированных символов в виде треугольника\n");

        TrianglePrinter.print('0', '9', true);
        System.out.println();
        TrianglePrinter.print('/', '!', false);
        System.out.println();
        TrianglePrinter.print('A', 'J', false);

        System.out.println("\n5. Заполнение массива уникальными числами\n");

        System.out.println(SegmentPrinter.createAndPrint(-30, -10, 23) + "\n");
        System.out.println(SegmentPrinter.createAndPrint(-30, 10, 10) + "\n");
        System.out.println(SegmentPrinter.createAndPrint(-34, -34, 0) + "\n");
        System.out.println(SegmentPrinter.createAndPrint(-1, 2, -3) + "\n");
        System.out.println(SegmentPrinter.createAndPrint(5, -8, 2));

        System.out.println("\n6. Вывод текста с эффектом пишущей машинки\n");

        TextPrinter.print("1) Java - это C++, из которого убрали все пистолеты, " +
                "ножи и дубинки.\n- James Gosling");
        System.out.println();
        TextPrinter.print("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin");
        System.out.println();
        TextPrinter.print(null);
        System.out.println();
        TextPrinter.print("");
    }

    private static void printFactorials(int[] initials, int[] factorials) {
        if (initials == null || factorials == null) {
            System.out.println("Ошибка: Ни один из аргументов не может быть null");
            return;
        }

        int length = initials.length;

        for (int i = 0; i < length; i++) {
            System.out.println(formatFactorials(initials[i], factorials[i]));
        }
    }

    private static String formatFactorials(int number, int result) {
        if (number == 0 || number == 1) {
            return String.format("%d! = %d", number, result);
        } else if (number < 0) {
            return String.format("Ошибка: факториал %d! не определен", number);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            sb.append(i).append(i == number ? "" : " * ");
        }

        return String.format("%d! = %s = %d", number, sb, result);
    }
}
