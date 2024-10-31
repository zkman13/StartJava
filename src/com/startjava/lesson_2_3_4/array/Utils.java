package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Utils {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n1. Реверс значений массива\n");

        int[] numbersToReverse;
        int[] reversedNumbers;

        numbersToReverse = null;
        reversedNumbers = Reverser.reverse(null);
        System.out.printf("До реверса: %s\n", Arrays.toString(numbersToReverse));
        System.out.printf("После реверса: %s\n", Arrays.toString(reversedNumbers));

        System.out.println();

        numbersToReverse = new int[]{6, 8, 9, 1};
        reversedNumbers = Reverser.reverse(numbersToReverse);
        System.out.printf("До реверса: %s\n", Arrays.toString(numbersToReverse));
        System.out.printf("После реверса: %s\n", Arrays.toString(reversedNumbers));

        System.out.println();

        numbersToReverse = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedNumbers = Reverser.reverse(numbersToReverse);
        System.out.printf("До реверса: %s\n", Arrays.toString(numbersToReverse));
        System.out.printf("После реверса: %s\n", Arrays.toString(reversedNumbers));

        System.out.println("\n2. Вычисление факториала\n");

        int[] factorialNumbers;
        int[] factorialValues;

        factorialNumbers = null;
        factorialValues = FactorialCalculator.calculate(null);
        FactorialCalculator.printAll(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = new int[]{8, 0, 9};
        factorialValues = FactorialCalculator.calculate(8, 0, 9);
        FactorialCalculator.printAll(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = new int[]{-3, 1, 7, 13};
        factorialValues = FactorialCalculator.calculate(-3, 1, 7, 13);
        FactorialCalculator.printAll(factorialNumbers, factorialValues);

        System.out.println();

        factorialNumbers = new int[]{-22, -0};
        factorialValues = FactorialCalculator.calculate(-22, -0);
        FactorialCalculator.printAll(factorialNumbers, factorialValues);

        System.out.println("\n4. Вывод отсортированных символов в виде треугольника\n");

        TrianglePrinter.print('0', '9', true);
        System.out.println();
        TrianglePrinter.print('/', '!', false);
        System.out.println();
        TrianglePrinter.print('A', 'J', false);

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
}
