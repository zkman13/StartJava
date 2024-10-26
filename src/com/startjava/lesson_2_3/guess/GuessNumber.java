package com.startjava.lesson_2_3.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private final Scanner scanner;
    private final Player player1;
    private final Player player2;

    public GuessNumber(Player player1, Player player2, Scanner scanner) {
        this.scanner = scanner;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Player curPlayer = player1;
        int randomNumber = new Random().nextInt(100) + 1;
        String player1Name = player1.getName();
        String player2Name = player2.getName();
        int playerNumber = 0;
        System.out.println("Угадайте число от 1 до 100!");

        while (!isAnswerCorrect(playerNumber, randomNumber)) {
            playerNumber = askForPlayerGuess(curPlayer.getName());
            giveHint(playerNumber, randomNumber);
            curPlayer = curPlayer == player1 ? player2 : player1;
        }

        System.out.printf("%n%s победил!%n", curPlayer == player1 ? player2Name : player1Name);
    }

    private boolean isAnswerCorrect(int playerNumber, int randomNumber) {
        return playerNumber == randomNumber;
    }

    private int askForPlayerGuess(String playerName) {
        int playerNumber;

        while (true) {
            System.out.printf("%nУгадывает %s. Введите число: ", playerName);

            try {
                playerNumber = scanner.nextInt();
                scanner.skip("\n");
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
}
