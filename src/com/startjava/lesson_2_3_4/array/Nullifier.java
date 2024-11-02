package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class Nullifier {

    public static void nullify(int index) {
        if (index < 0 || index > 14) {
            System.out.println("Ошибка: индекс должен быть от 0 до 14");
            return;
        }

        double[] randomized = fillWithRandom();
        Object[] result = replaceGreaterWithZero(index, randomized);
        double[] replaced = (double[]) result[0];
        int zeroCount = (int) result[1];

        printReport(randomized, replaced, index, zeroCount);
    }

    private static double[] fillWithRandom() {
        double[] array = new double[15];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble();
        }

        return array;
    }

    private static Object[] replaceGreaterWithZero(int index, double[] array) {
        double[] copied = Arrays.copyOf(array, array.length);
        int zeroCount = 0;

        for (int i = 0; i < copied.length; i++) {
            if (copied[i] > copied[index]) {
                copied[i] = 0;
                ++zeroCount;
            }
        }

        return new Object[]{copied, zeroCount};
    }

    private static void printReport(
            double[] randomized,
            double[] replaced,
            int arrayIndex,
            int zeroCount) {
        System.out.println("Массив с случайными числами:");
        printArrayTwoLines(randomized);
        System.out.println("Измененный массив:");
        printArrayTwoLines(replaced);
        System.out.printf("Значение по индексу %d: %.3f%n", arrayIndex, randomized[arrayIndex]);
        System.out.printf("Количество обнуленных элементов: %d%n", zeroCount);
    }

    private static void printArrayTwoLines(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f ", array[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
