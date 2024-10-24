package Lesson_2;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Scanner scanner;
    private boolean firstPlayerActive;
    private Player player1;
    private Player player2;

    public GuessNumber(Scanner scanner) {
        this.scanner = scanner;
    }

    private boolean isFirstPlayerActive() {
        return firstPlayerActive;
    }

    private void setFirstPlayerActive(boolean firstPlayerActive) {
        this.firstPlayerActive = firstPlayerActive;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void prepare() {
        System.out.print("\nВведите имя первого игрока: ");
        String player1Name = scanner.nextLine().trim();
        setPlayer1(new Player(player1Name));
        System.out.print("Введите имя второго игрока: ");
        String player2Name;

        do {
            player2Name = scanner.nextLine().trim();

            if (player1Name.equals(player2Name)) {
                System.out.printf("Имя %s уже занято! Укажите другое: ", player2Name);
            }
        } while (player1Name.equals(player2Name));

        setPlayer2(new Player(player2Name));
    }

    public void play() {
        setFirstPlayerActive(false);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        String player1Name = player1.getName();
        String player2Name = player2.getName();

        System.out.println("Угадайте число от 1 до 100!");

        int playerNumber = 0;

        while (playerNumber != randomNumber) {
            setFirstPlayerActive(!isFirstPlayerActive());
            System.out.printf("%nУгадывает %s. Введите число: ",
                    isFirstPlayerActive() ? player1Name : player2Name);

            try {
                playerNumber = scanner.nextInt();
                scanner.skip("\n");

                if (playerNumber < randomNumber) {
                    System.out.printf("%d меньше того, что загадал компьютер!%n", playerNumber);
                } else if (playerNumber > randomNumber) {
                    System.out.printf("%d больше того, что загадал компьютер!%n", playerNumber);
                }
            } catch (Exception e) {
                System.out.println("Вы должны ввести целое число!");
                scanner.nextLine();
                return;
            }
        }

        System.out.printf("%n%s победил!%n", isFirstPlayerActive() ? player1Name : player2Name);
    }

}
