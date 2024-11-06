package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static final int MAX_GUESSES = 10;
    private static final String MAIN_MESSAGE = "Хотите продолжить игру? [yes / no]: ";
    private static final String ALTERNATIVE_MESSAGE = "Введите корректный ответ [yes / no]: ";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] names = inputPlayerNames(scanner);
        Player player1 = new Player(names[0], MAX_GUESSES);
        Player player2 = new Player(names[1], MAX_GUESSES);
        GuessNumber game = new GuessNumber(player1, player2);

        do {
            System.out.println();
            game.play(scanner, MAX_GUESSES);
        } while (shouldContinue(scanner));

        scanner.close();
    }

    private static String[] inputPlayerNames(Scanner scanner) {
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

    private static boolean shouldContinue(Scanner scanner) {
        System.out.println();
        boolean isMainMessage = true;

        while (true) {
            System.out.print(isMainMessage ? MAIN_MESSAGE : ALTERNATIVE_MESSAGE);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true;
            }

            if (input.equals("no")) {
                return false;
            }

            isMainMessage = false;
        }
    }
}
