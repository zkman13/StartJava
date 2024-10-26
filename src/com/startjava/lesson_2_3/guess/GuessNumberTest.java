package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] names = promptPlayerNames();
        GuessNumber game = new GuessNumber(new Player(names[0]), new Player(names[1]), scanner);

        do {
            System.out.println();
            game.play();
        } while (shouldContinue());

        scanner.close();
    }

    private static String[] promptPlayerNames() {
        System.out.print("\nВведите имя первого игрока: ");
        String player1Name = scanner.nextLine().trim();
        System.out.print("Введите имя второго игрока: ");
        String player2Name;

        do {
            player2Name = scanner.nextLine().trim();

            if (player1Name.equals(player2Name)) {
                System.out.printf("Имя %s уже занято! Укажите другое: ", player2Name);
            }
        } while (player1Name.equals(player2Name));

        return new String[]{player1Name, player2Name};
    }

    private static boolean shouldContinue() {
        System.out.println();

        while (true) {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            }
        }
    }
}
