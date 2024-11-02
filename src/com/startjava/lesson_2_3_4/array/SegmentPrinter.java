package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class SegmentPrinter {

    public static String createAndPrint(int left, int right, int capacity) {
        if (capacity < 1) {
            return String.format("Ошибка: количество чисел в строке не может быть меньше 1 (%d)", capacity);
        } else if (left > right) {
            return String.format("Ошибка: левая граница (%d) > правой (%d)", left, right);
        }

        int segmentLength = Math.abs(right - left);
        int arrayLength = (int) Math.round(segmentLength * 0.75);

        if (arrayLength < 1) {
            return String.format("Ошибка: длина массива должна быть больше 0 (%d)", arrayLength);
        }

        int[] randomized = createUniqueArray(left, segmentLength, arrayLength);
        int[] sorted = sort(randomized);

        return buildOutputString(sorted, capacity);
    }

    private static boolean contains(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }

        return false;
    }

    private static int[] createUniqueArray(int left, int segmentLength, int length) {
        int[] array = new int[length];
        Random r = new Random();
        int count = 0;

        while (count < length) {
            int num = left + r.nextInt(segmentLength + 1);

            if (!contains(array, num)) {
                array[count] = num;
                count++;
            }
        }

        return array;
    }

    private static int[] sort(int[] array) {
        int[] copied = array.clone();
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (copied[i] > copied[i + 1]) {
                    int temp = copied[i];
                    copied[i] = copied[i + 1];
                    copied[i + 1] = temp;
                    isSorted = false;
                }
            }
        }

        return copied;
    }

    private static String buildOutputString(int[] array, int capacity) {
        int length = array.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(String.format("%4d", array[i]));

            if (i % capacity == 0 && i != 0) {
                sb.append("\n");
            } else {
                sb.append(i == length - 1 ? "" : " ");
            }
        }

        return sb.toString();
    }
}
