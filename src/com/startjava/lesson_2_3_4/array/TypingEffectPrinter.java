package com.startjava.lesson_2_3_4.array;

public class TypingEffectPrinter {

    public static void printWithTypingEffect(String text) throws InterruptedException {
        if (text == null) {
            System.out.println("Ошибка: необходимо передать строку");
            return;
        }

        int[] range = findHighlightRange(text);
        int leftIdx = range[0];
        int rightIdx = range[1];

        type(text, leftIdx, rightIdx);
    }

    private static int[] findHighlightRange(String text) {
        int shortWordLength = Integer.MAX_VALUE;
        int longWordLength = Integer.MIN_VALUE;
        int leftIdx = 0;
        int rightIdx = 0;
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                counter++;
            } else if (counter > 0) {
                if (counter < shortWordLength) {
                    shortWordLength = counter;
                    leftIdx = i - shortWordLength;
                } else if (counter > longWordLength) {
                    longWordLength = counter;
                    rightIdx = i;
                }

                counter = 0;
            }
        }

        return new int[]{leftIdx, rightIdx};
    }

    private static void type(String text, int leftIdx, int rightIdx) throws InterruptedException {
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            System.out.print(isInRange(i, leftIdx, rightIdx) ? String.valueOf(ch).toUpperCase() : ch);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println();
    }

    private static boolean isInRange(int index, int leftIdx, int rightIdx) {
        return index >= leftIdx && index <= rightIdx;
    }
}
