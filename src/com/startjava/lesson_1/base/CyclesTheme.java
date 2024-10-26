package com.startjava.lesson_1.base;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел\n");

        int minNumber = -10;
        int maxNumber = 21;
        int sumEvenNumbers = 0;
        int sumOddNumbers = 0;
        int currentNumber = minNumber;

        do {
            if (currentNumber % 2 == 0) {
                sumEvenNumbers += currentNumber;
            } else {
                sumOddNumbers += currentNumber;
            }

            currentNumber++;
        } while (currentNumber <= maxNumber);

        System.out.println("В отрезке [" + minNumber + ", " + maxNumber + "] сумма четных чисел = " +
                sumEvenNumbers + ", а нечетных = " + sumOddNumbers);

        System.out.println("\n2. Подсчет суммы четных и нечетных чисел\n");

        int a = 10;
        int b = 5;
        int c = -1;
        int min = a;
        int max = a;

        if (b < min) {
            min = b;
        }
        if (b > max) {
            max = b;
        }
        if (c < min) {
            min = c;
        }
        if (c > max) {
            max = c;
        }

        System.out.print("Числа в интервале (" + min + ", " + max + "): ");

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр\n");

        int number = 1234;
        int sum = 0;

        System.out.print("Реверсивное число: ");
        while (number > 0) {
            int digit = number % 10;
            System.out.print(digit);
            sum += digit;
            number /= 10;
        }

        System.out.println("\nСумма цифр: " + sum);

        System.out.println("\n4. Вывод чисел в несколько строк\n");

        minNumber = 1;
        maxNumber = 24;
        int count = 0;

        for (int i = minNumber; i < maxNumber; i++) {
            if (i % 2 != 0) {
                count++;
                System.out.printf("%2d ", i);

                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }

        int missing = (5 - (count % 5)) % 5;

        for (int i = 0; i < missing; i++) {
            System.out.printf("%2d ", 0);
        }

        if (count > 0) {
            System.out.println();
        }

        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность\n");

        int initialNumber = 3242592;
        int initialNumberCopy = initialNumber;
        int twosCount = 0;

        while (initialNumberCopy > 0) {
            if (initialNumberCopy % 10 == 2) {
                twosCount++;
            }
            initialNumberCopy /= 10;
        }
        String parity = "нечетное";

        if (twosCount % 2 == 0) {
            parity = "четное";
        }

        System.out.printf("В %d %s (%d) количество двоек%n", initialNumber, parity, twosCount);

        System.out.println("\n6. Вывод геометрических фигур\n");

        final int rectangleWidth = 10;
        final int rectangleHeight = 5;

        for (int i = 0; i < rectangleHeight; i++) {
            for (int j = 0; j < rectangleWidth; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();

        int lineWidth = 5;
        int lineWidthCounter = lineWidth;
        int lineCounter = 0;

        while (lineCounter < lineWidth && lineWidthCounter > 0) {
            System.out.print("#");

            lineWidthCounter--;

            if (lineWidthCounter == 0) {
                lineWidth--;
                lineWidthCounter = lineWidth;
                System.out.println();
            }
        }

        System.out.println();

        final String isoscelesTriangleSymbol = "$";

        int isoscelesTriangleWidth = 1;
        int isoscelesTriangleHeight = 5;
        int triangleLineCounter = 0;
        boolean isIncreasing = true;

        do {
            do {
                System.out.print(isoscelesTriangleSymbol);
                triangleLineCounter++;
            } while (triangleLineCounter < isoscelesTriangleWidth);

            isoscelesTriangleHeight--;
            triangleLineCounter = 0;

            if (isIncreasing) {
                isoscelesTriangleWidth++;
            } else {
                isoscelesTriangleWidth--;
            }

            if (isoscelesTriangleWidth == 3) {
                isIncreasing = false;
            }

            System.out.println();
        } while (isoscelesTriangleHeight > 0);

        System.out.println("\n7. Вывод ASCII-символов\n");

        System.out.printf("%-9s %-11s %11s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int code = 33; code <= 45; code += 2) {
            char character = (char) code;
            String description = Character.getName(character);

            System.out.printf("%1s %-11d %-12c %s%n", "", code, character, description);
        }

        for (int code = 98; code <= 122; code += 2) {
            char character = (char) code;
            String description = Character.getName(character);

            System.out.printf("%1s %-11d %-12c %s%n", "", code, character, description);
        }

        System.out.println("\n8. Проверка, является ли число палиндромом\n");

        initialNumber = 1234321;
        initialNumberCopy = initialNumber;
        int reversedNumber = 0;

        while (initialNumber > 0) {
            int digit = initialNumber % 10;
            reversedNumber = reversedNumber * 10 + digit;
            initialNumber /= 10;
        }

        if (initialNumberCopy == reversedNumber) {
            System.out.printf("%d является палиндромом%n", initialNumberCopy);
        } else {
            System.out.printf("%d не является палиндромом%n", initialNumberCopy);
        }

        System.out.println("\n9. Проверка, является ли число счастливым\n");

        int luckyNumber = 123321;
        initialNumberCopy = luckyNumber;
        int sumLeft = 0;
        int sumRight = 0;
        int leftPart = 0;
        int rightPart = 0;
        int leftCoef = 1;
        int rightCoef = 1;

        for (int i = 0; i < 6; i++) {
            int digit = luckyNumber % 10;
            luckyNumber /= 10;

            if (i < 3) {
                sumRight += digit;
                rightPart += digit * rightCoef;
                rightCoef *= 10;
            } else {
                sumLeft += digit;
                leftPart += digit * leftCoef;
                leftCoef *= 10;
            }
        }

        System.out.printf("Число %d - %s%n", initialNumberCopy, (sumLeft == sumRight) ?
                "счастливое" : "не является счастливым");
        System.out.printf("Сумма цифр %d = %d%n", leftPart, sumLeft);
        System.out.printf("Сумма цифр %d = %d%n", rightPart, sumRight);

        System.out.println("\n10. Вывод таблицы умножения Пифагора\n");

        int size = 9;

        System.out.print("    |");

        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i);
        }

        System.out.println("\n----+-----------------------------------");

        for (int i = 1; i <= size; i++) {
            System.out.printf("%3d |", i);

            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }

            System.out.println();
        }
    }
}
