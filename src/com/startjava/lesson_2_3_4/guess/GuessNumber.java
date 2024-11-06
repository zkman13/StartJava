package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private final Player player1;
    private final Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(Scanner scanner, int maxGuesses) {
        Player curPlayer = player1;
        int randomNumber = new Random().nextInt(100) + 1;
        int playerNumber = 0;
        boolean isWinner = true;
        System.out.println("Угадайте число от 1 до 100!");
        System.out.println("Игра началась! У каждого игрока по 10 попыток.");

        while (true) {
            playerNumber = askForPlayerGuess(curPlayer.getName(), scanner);
            giveHint(playerNumber, randomNumber);
            curPlayer.addGuess(playerNumber);

            if (isGuessed(playerNumber, randomNumber)) break;

            if (curPlayer.getAttempt() == maxGuesses) {
                isWinner = false;
                break;
            }

            curPlayer = curPlayer == player1 ? player2 : player1;
        }

        printGameResults(isWinner, curPlayer);
        reset();
    }

    private int askForPlayerGuess(String playerName, Scanner scanner) {
        int playerNumber;

        while (true) {
            System.out.printf("%nУгадывает %s. Введите число: ", playerName);

            try {
                playerNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (RuntimeException e) {
                System.out.println("Вы должны ввести целое число!");
                scanner.nextLine();
            }
        }

        return playerNumber;
    }

    private void giveHint(int playerNumber, int randomNumber) {
        if (playerNumber < randomNumber) {
            System.out.printf("%d меньше того, что загадал компьютер!%n", playerNumber);
        } else if (playerNumber > randomNumber) {
            System.out.printf("%d больше того, что загадал компьютер!%n", playerNumber);
        }
    }

    private boolean isGuessed(int playerNumber, int randomNumber) {
        return playerNumber == randomNumber;
    }

    private void printGameResults(boolean isWinner, Player curPlayer) {
        if (isWinner) {
            String winner = curPlayer.getName();
            int guessCount = curPlayer.getAttempt();
            int winningGuess = curPlayer.getGuesses()[guessCount - 1];

            System.out.printf("%n%s угадывал: %s%n", player1.getName(), getStringGuesses(player1.getGuesses()));
            System.out.printf("%s угадывал: %s%n", player2.getName(), getStringGuesses(player2.getGuesses()));
            System.out.printf("%n%s угадал число %d с %d-й попытки", winner, winningGuess, guessCount);
            System.out.printf("%n%s победил!%n", winner);
        } else {
            System.out.printf("%nУ %s закончились попытки!%n", curPlayer.getName());
        }
    }

    private String getStringGuesses(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int n : nums) {
            sb.append(n).append(" ");
        }

        return sb.toString().trim();
    }

    private void reset() {
        player1.reset();
        player2.reset();
    }
}
