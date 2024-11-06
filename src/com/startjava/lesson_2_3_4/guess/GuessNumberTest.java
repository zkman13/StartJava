package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static final int MAX_GUESSES = 10;
    private static final int MAX_PLAYERS = 3;
    private static final String MAIN_MESSAGE = "Хотите продолжить игру? [yes / no]: ";
    private static final String ALTERNATIVE_MESSAGE = "Введите корректный ответ [yes / no]: ";
    private static final String[] playerNames = new String[MAX_PLAYERS];

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        inputPlayerNames(scanner);
        Player[] players = initPlayers();
        GuessNumber game = new GuessNumber(players);

        do {
            System.out.println();
            game.play(scanner, MAX_GUESSES, MAX_PLAYERS);
        } while (shouldContinue(scanner));

        scanner.close();
    }

    private static Player[] initPlayers() {
        Player[] players = new Player[MAX_PLAYERS];

        for (int i = 0; i < MAX_PLAYERS; i++) {
            players[i] = new Player(playerNames[i], MAX_GUESSES);
        }

        return players;
    }

    private static void inputPlayerNames(Scanner scanner) {
        int playerCount = 0;
        String playerName;
        System.out.println();

        do {
            System.out.printf("Введите имя %d-го игрока: ", playerCount + 1);

            do {
                playerName = scanner.nextLine().trim();

                if (doesPlayerExist(playerName)) {
                    System.out.printf("Имя %s уже занято! Укажите другое: ", playerName);
                }
            } while (doesPlayerExist(playerName));

            playerNames[playerCount++] = playerName;
        } while (playerCount < MAX_PLAYERS);
    }

    private static boolean doesPlayerExist(String playerName) {
        for (String name : playerNames) {
            if (name == null) {
                continue;
            }

            if (name.equals(playerName)) {
                return true;
            }
        }

        return false;
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
