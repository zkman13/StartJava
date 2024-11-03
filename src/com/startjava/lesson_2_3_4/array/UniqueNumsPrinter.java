package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumsPrinter {

    public static String createAndPrint(int left, int right, int capacity) {
        if (capacity < 1) {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)", capacity);
            return "";
        }

        if (left > right) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)", left, right);
            return "";
        }

        int segmentLength = Math.abs(right - left);
        int arrayLength = (int) Math.round(segmentLength * 0.75);

        if (arrayLength < 1) {
            return String.format("Ошибка: длина массива должна быть больше 0 (%d)", arrayLength);
        }

        int[] uniqueNums = createUniqueArray(left, right, arrayLength);
        Arrays.sort(uniqueNums);

        return buildOutputString(uniqueNums, capacity);
    }

    private static int[] createUniqueArray(int left, int right, int length) {
        int[] array = new int[length];
        Random r = new Random();
        int count = 0;

        while (count < length) {
            int num = r.nextInt(left, right + 1);

            if (!contains(array, num)) {
                array[count] = num;
                count++;
            }
        }

        return array;
    }

    private static boolean contains(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }

        return false;
    }

    private static String buildOutputString(int[] array, int capacity) {
        int length = array.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(String.format("%4d", array[i]));

            if ((i + 1) % capacity == 0 && i != 0) {
                sb.append("\n");
            } else {
                sb.append(i == length - 1 ? "" : " ");
            }
        }

        return sb.toString();
    }
}
