package Lesson_2;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberTest {

    private static final Scanner scanner = new Scanner(System.in);

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

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(scanner);
        game.prepare();

        do {
            System.out.println();
            game.play();
        } while (shouldContinue());

        scanner.close();
    }
}
