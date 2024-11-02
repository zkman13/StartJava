package com.startjava.lesson_2_3_4.array;

public class Reverser {

    public static int[] reverse(int[] toReverse) {
        if (toReverse == null) {
            return null;
        }

        int length = toReverse.length;
        int[] reversed = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            reversed[length - i - 1] = toReverse[i];
        }

        return reversed;
    }
}
