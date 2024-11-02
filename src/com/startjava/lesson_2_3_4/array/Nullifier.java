package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class Nullifier {

    public static Object[] nullify(int index) {
        if (index < 0 || index > 14) {
            System.out.println("Ошибка: индекс должен быть от 0 до 14");
            return null;
        }

        double[] randomized = fillWithRandom();
        Object[] result = replaceGreaterWithZero(index, randomized);

        return new Object[]{randomized, result[0], result[1]};
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
}
