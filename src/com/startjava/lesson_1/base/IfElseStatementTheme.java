package com.startjava.lesson_1.base;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Перевод псевдокода на язык Java\n");

        boolean isMale = true;

        if (!isMale) {
            System.out.println("Пол: Женский");
        } else {
            System.out.println("Пол: Мужской");
        }

        int age = 20;

        if (age > 18) {
            System.out.println("Взрослый");
        } else {
            System.out.println("Несовершеннолетний");
        }

        double height = 1.75;

        if (height < 1.8) {
            System.out.println("Рост меньше чем 1.8 метра");
        } else {
            System.out.println("Рост 1.8 метра или больше");
        }

        String name = "Иван";
        char firstNameLetter = name.charAt(0);

        if (firstNameLetter == 'М') {
            System.out.println("Имя начинается на М");
        } else if (firstNameLetter == 'И') {
            System.out.println("Имя начинается на И");
        } else {
            System.out.println("Имя не начинается на М или И");
        }

        System.out.println("\n2. Поиск большего числа\n");

        int number1 = 123;
        int number2 = 223;

        if (number1 > number2) {
            System.out.println(number1 + " больше чем " + number2);
        } else if (number2 > number1) {
            System.out.println(number2 + " больше чем " + number1);
        } else {
            System.out.println(number1 + " и " + number2 + " равны");
        }

        System.out.println("\n3. Проверка числа\n");

        int number = -10;

        if (number == 0) {
            System.out.println("Число равно нулю.");
        } else {
            if (number > 0) {
                System.out.print(number + " является положительным");
            } else {
                System.out.print(number + " является отрицательным");
            }

            if (number % 2 == 0) {
                System.out.println(" и четным.");
            } else {
                System.out.println(" и нечетным.");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах\n");

        int hundreds1 = number1 / 100;
        int tens1 = (number1 / 10) % 10;
        int ones1 = number1 % 10;
        int hundreds2 = number2 / 100;
        int tens2 = (number2 / 10) % 10;
        int ones2 = number2 % 10;

        if (hundreds1 == hundreds2 && tens1 == tens2 && ones1 == ones2) {
            System.out.println("Все цифры в числах " + number1 + " и " + number2 + " одинаковы.");
        } else if (hundreds1 != hundreds2 && tens1 != tens2 && ones1 != ones2) {
            System.out.println("Одинаковых цифр в разрядах чисел " + number1 + " и " + number2 + " нет.");
        } else {
            System.out.println("Числа: " + number1 + " и " + number2);

            if (hundreds1 == hundreds2) {
                System.out.println("Цифры " + hundreds1 + " в третьем разряде одинаковы.");
            }

            if (tens1 == tens2) {
                System.out.println("Цифры " + tens1 + " во втором разряде одинаковы.");
            }

            if (ones1 == ones2) {
                System.out.println("Цифры " + ones1 + " в первом разряде одинаковы.");
            }
        }

        System.out.println("\n5. Определение символа по его коду\n");

        char unknownChar = '\u0057';

        if (Character.isLetter(unknownChar)) {
            System.out.println(unknownChar + " " + (Character.isUpperCase(unknownChar) ?
                    "- большая буква" : "- маленькая буква"));
        } else if (Character.isDigit(unknownChar)) {
            System.out.println("'" + unknownChar + "' - цифра");
        } else {
            System.out.println("'" + unknownChar + "' - ни буква и ни цифра");
        }

        System.out.println("\n6. Подсчет начисленных банком %\n");

        double deposit = 321123.59;
        double interestRate = 0.10;

        if (deposit < 100000) {
            interestRate = 0.05;
        } else if (deposit <= 300000) {
            interestRate = 0.07;
        }

        double interest = deposit * interestRate;
        double totalAmount = deposit + interest;

        System.out.println("Сумма вклада: " + deposit + " руб.");
        System.out.println("Сумма начисленного %: " + interest + " руб.");
        System.out.println("Итоговая сумма с %: " + totalAmount + " руб.");

        System.out.println("\n7. Определение оценки по предметам\n");

        double historyPercentage = 59.0;
        int historyGrade = 5;

        if (historyPercentage <= 60) {
            historyGrade = 2;
        } else if (historyPercentage <= 73) {
            historyGrade = 3;
        } else if (historyPercentage <= 91) {
            historyGrade = 4;
        }

        double programmingPercentage = 92.0;
        int programmingGrade = 5;

        if (programmingPercentage <= 60) {
            programmingGrade = 2;
        } else if (programmingPercentage <= 73) {
            programmingGrade = 3;
        } else if (programmingPercentage <= 91) {
            programmingGrade = 4;
        }

        double averageGrade = (historyGrade + programmingGrade) / 2.0;
        double averagePercentage = (historyPercentage + programmingPercentage) / 2.0;

        System.out.println("История: " + historyGrade);
        System.out.println("Программирование: " + programmingGrade);
        System.out.println("Средний балл оценок: " + averageGrade);
        System.out.println("Средний % по предметам: " + averagePercentage);

        System.out.println("\n8. Расчет годовой прибыли\n");

        double monthlySales = 13025.233;
        double monthlyRent = 5123.018;
        double monthlyCost = 9001.729;
        double annualProfit = (monthlySales - (monthlyRent + monthlyCost)) * 12;
        String sign = "";

        if (annualProfit > 0) {
            sign = "+";
        }

        System.out.println("Прибыль за год: " + sign + annualProfit + " руб.");
    }
}