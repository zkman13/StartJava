package com.startjava.lesson_1.final_;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        System.out.println("Угадайте число от 1 до 100!");

        Scanner scanner = new Scanner(System.in);
        int playerNumber = 0;

        while (playerNumber != randomNumber) {
            System.out.print("Введите число: ");

            try {
                playerNumber = scanner.nextInt();

                if (playerNumber < randomNumber) {
                    System.out.printf("%d меньше того, что загадал компьютер!%n", playerNumber);
                } else if (playerNumber > randomNumber) {
                    System.out.printf("%d больше того, что загадал компьютер!%n", playerNumber);
                }
            } catch (Exception e) {
                System.out.println("Вы должны ввести целое число!");
                scanner.close();
                return;
            }
        }

        System.out.println("Вы победили!");
        scanner.close();
    }
}
