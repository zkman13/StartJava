import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        System.out.println("Угадайте число от 1 до 100!");

        Scanner scanner = new Scanner(System.in);
        int parsedRandomNumber = 0;

        while (parsedRandomNumber != randomNumber) {
            System.out.print("Введите число: ");
            String input = scanner.nextLine().trim();

            try {
                parsedRandomNumber = Integer.parseInt(input);

                if (parsedRandomNumber == randomNumber) {
                    System.out.println("Вы победили!");
                } else if (parsedRandomNumber < randomNumber) {
                    System.out.printf("%d меньше того, что загадал компьютер!\n", parsedRandomNumber);
                } else {
                    System.out.printf("%d больше того, что загадал компьютер!\n", parsedRandomNumber);
                }
            } catch (Exception e) {
                System.out.println("Вы должны ввести целое число!");
                System.exit(0);
            }
        }

        scanner.close();
    }
}
