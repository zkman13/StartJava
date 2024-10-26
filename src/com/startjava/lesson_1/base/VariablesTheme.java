package com.startjava.lesson_1.base;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Вывод характеристик компьютера\n");

        byte cores = 8;
        short ramSize = 16;
        int hddSize = 1000;
        long cpuFrequency = 3200L;
        float gpuMemory = 8.0f;
        double cpuTemperature = 65.5;
        boolean isGamingPc = true;
        char modelPrefix = 'G';

        System.out.println("Описание характеристик компьютера:");
        System.out.println("Количество ядер процессора: " + cores);
        System.out.println("Размер оперативной памяти: " + ramSize + " ГБ");
        System.out.println("Размер жесткого диска: " + hddSize + " ГБ");
        System.out.println("Частота процессора: " + cpuFrequency + " МГц");
        System.out.println("Объем видеопамяти: " + gpuMemory + " ГБ");
        System.out.println("Температура процессора: " + cpuTemperature + " °C");
        System.out.println("Игровой ПК: " + isGamingPc);
        System.out.println("Префикс модели: " + modelPrefix);

        System.out.println("\n2. Расчет стоимости товара со скидкой\n");

        double penPrice = 105.5;
        double bookPrice = 235.83;
        double discountRate = 0.11;
        double basePrice = penPrice + bookPrice;
        double discountAmount = basePrice * discountRate;
        double discountPrice = basePrice - discountAmount;

        System.out.println("Стоимость товаров без скидки: " + basePrice + " руб.");
        System.out.println("Сумма скидки: " + discountAmount + " руб.");
        System.out.println("Стоимость товаров со скидкой: " + discountPrice + " руб.");

        System.out.println("\n3. Вывод слова JAVA\n");

        System.out.println("    J    a  v     v  a");
        System.out.println("    J   a a  v   v  a a");
        System.out.println(" J  J  aaaaa  V V  aaaaa");
        System.out.println("  JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов\n");

        byte byteValue = Byte.MAX_VALUE;
        System.out.println("byte:");
        System.out.println("Первоначальное значение: " + byteValue);
        System.out.println("После инкремента: " + (++byteValue));
        System.out.println("После декремента: " + (--byteValue) + "\n");

        short shortValue = Short.MAX_VALUE;
        System.out.println("short:");
        System.out.println("Первоначальное значение: " + shortValue);
        System.out.println("После инкремента: " + (++shortValue));
        System.out.println("После декремента: " + (--shortValue) + "\n");

        int intValue = Integer.MAX_VALUE;
        System.out.println("int:");
        System.out.println("Первоначальное значение: " + intValue);
        System.out.println("После инкремента: " + (++intValue));
        System.out.println("После декремента: " + (--intValue) + "\n");

        long longValue = Long.MAX_VALUE;
        System.out.println("long:");
        System.out.println("Первоначальное значение: " + longValue);
        System.out.println("После инкремента: " + (++longValue));
        System.out.println("После декремента: " + (--longValue) + "\n");

        char charValue = Character.MAX_VALUE;
        System.out.println("char:");
        System.out.println("Первоначальное значение: " + (int) charValue);
        System.out.println("После инкремента: " + (int) (++charValue));
        System.out.println("После декремента: " + (int) (--charValue));

        System.out.println("\n5. Перестановка значений переменных\n");

        int a = 2;
        int b = 5;

        System.out.println("Исходные значения переменных:\na: " + a + ", b: " + b + "\n");

        int temp = a;
        a = b;
        b = temp;

        System.out.println("Способ 1: с помощью третьей переменной" +
                "\nНовые значения переменных:\na: " + a + ", b: " + b + "\n");

        a += b;
        b = a - b;
        a -= b;

        System.out.println("Способ 2: с помощью арифметических операций" +
                "\nНовые значения переменных:\na: " + a + ", b: " + b + "\n");

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("Способ 3: с помощью побитовой операции " +
                "^\nНовые значения переменных:\na: " + a + ", b: " + b);

        System.out.println("\n6. Вывод символов и их кодов\n");

        char dollarSymbol = '$';
        char asteriskSymbol = '*';
        char atSymbol = '@';
        char pipeSymbol = '|';
        char tildeSymbol = '~';

        System.out.println((int) dollarSymbol + " " + dollarSymbol);
        System.out.println((int) asteriskSymbol + " " + asteriskSymbol);
        System.out.println((int) atSymbol + " " + atSymbol);
        System.out.println((int) pipeSymbol + " " + pipeSymbol);
        System.out.println((int) tildeSymbol + " " + tildeSymbol);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка\n");

        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char parenthesesLeft = '(';
        char parenthesesRight = ')';

        System.out.println("    " + slash + backslash + "\n" +
                "   " + slash + "  " + backslash + "\n" +
                "  " + slash + underscore + parenthesesLeft + " " + parenthesesRight + backslash + "\n" +
                " " + slash + "      " + backslash + "\n" +
                slash + underscore + underscore + underscore + underscore + backslash + slash + underscore +
                underscore + backslash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа\n");

        int number = 123;
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;
        int sum = hundreds + tens + ones;
        int product = hundreds * tens * ones;

        System.out.printf("Число %d содержит:%n", number);
        System.out.printf("  сотен - %d%n", hundreds);
        System.out.printf("  десятков - %d%n", tens);
        System.out.printf("  единиц - %d%n", ones);
        System.out.printf("Сумма разрядов = %d%n", sum);
        System.out.printf("Произведение разрядов = %d%n", product);

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды\n");

        int totalSeconds = 86399;
        int hh = totalSeconds / 3600;
        int mm = (totalSeconds % 3600) / 60;
        int ss = totalSeconds % 60;

        System.out.printf("%02d:%02d:%02d%n", hh, mm, ss);
    }
}