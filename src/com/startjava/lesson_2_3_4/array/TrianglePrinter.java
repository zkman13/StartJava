package com.startjava.lesson_2_3_4.array;

public class TrianglePrinter {

    public static void print(char start, char end, boolean asc) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", (int) start, (int) end);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int totalLines = end - start + 1;
        int maxCharsInLine = (end - start) * 2 + 1;
        int lineShift = maxCharsInLine / 2;
        int charNumberInLine = 1;
        char currentChar = asc ? start : end;
        int lineCounter = 0;

        do {
            lineCounter++;
            sb.append(" ".repeat(lineShift))
                    .append(String.valueOf(currentChar).repeat(charNumberInLine))
                    .append(lineCounter < totalLines ? "\n" : "");
            charNumberInLine += 2;
            lineShift--;
            currentChar += (char) (asc ? 1 : -1);
        } while (lineCounter < totalLines);

        System.out.println(sb.toString());
    }
}
