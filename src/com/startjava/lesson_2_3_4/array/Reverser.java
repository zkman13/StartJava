package com.startjava.lesson_2_3_4.array;

public class Reverser {

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }

        int length = numbers.length;
        int[] newNumbers = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            newNumbers[length - i - 1] = numbers[i];
        }

        return newNumbers;
    }
}
