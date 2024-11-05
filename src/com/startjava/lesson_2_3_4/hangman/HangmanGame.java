package com.startjava.lesson_2_3_4.hangman;

import java.util.*;
import java.util.stream.Collectors;

public class HangmanGame {
    private final String[] words;
    private final Set<Character> wrongLetters = new HashSet<>();
    private final Set<Character> guessedLetters = new HashSet<>();
    private String guessedWord;
    private String displayedWord;
    private int attemptCount = 5;
    private int stage = 0;

    public HangmanGame(String[] words) {
        this.words = words;
    }

    public void play() {
        final Scanner scanner = new Scanner(System.in);
        initGuessedWord();
        initDisplayedWord(guessedWord.length());
        displayGameScreen();

        while (true) {
            char guess = input(scanner);

            if (isGuessedLetter(guess)) {
                guessedLetters.add(guess);
                increaseAttemptCount();
                decreaseStage();
            } else {
                wrongLetters.add(guess);
                decreaseAttemptCount();
                increaseStage();
            }

            displayGameScreen();

            if (isGuessedWord()) {
                System.out.println("\nВы угадали!");
                break;
            }

            if (attemptCount == 0) {
                System.out.println("\nВы труп!");
                System.out.printf("Загаданное слово: %s%n", guessedWord);
                break;
            }
        }

        scanner.close();
    }

    private void initGuessedWord() {
        Random r = new Random();
        int index = r.nextInt(words.length);
        guessedWord = words[index].toUpperCase();
    }

    private void initDisplayedWord(int length) {
        displayedWord = "_".repeat(length);
    }

    private void displayGameScreen() {
        displayWord();
        displayAttempts();
        displayWrongLetters();
        displayGallows(stage);
    }

    private void displayWord() {
        displayedWord = guessedWord
                .chars()
                .mapToObj(ch -> guessedLetters.contains((char) ch) ? (char) ch : '_')
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.printf("%nЗагаданное слово (%d): %s%n", displayedWord.length(), displayedWord);
    }

    private void displayAttempts() {
        System.out.printf("Количество попыток: %d%n", attemptCount);
    }

    private void displayWrongLetters() {
        String result = wrongLetters
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("Неверные буквы: %s%n%n", result);
    }

    private void displayGallows(int stage) {
        String[] gallows = {
                "__________\n",
                "|/    |    \n",
                "|          \n",
                "|          \n",
                "|          \n",
                "|          \n",
                "=========="
        };

        gallows = updateGallows(gallows, stage);
        System.out.println(Arrays.stream(gallows).reduce("", (a, b) -> a + b));
    }

    private String[] updateGallows(String[] gallows, int stage) {
        String[] copied = gallows.clone();

        if (stage >= 1) {
            copied[2] = "|     0    \n";
        }

        if (stage >= 2) {
            copied[3] = "|    /|    \n";
        }

        if (stage >= 3) {
            copied[3] = "|    /|\\   \n";
        }

        if (stage >= 4) {
            copied[4] = "|    /     \n";
        }

        if (stage == 5) {
            copied[4] = "|    / \\   \n";
        }

        return copied;
    }

    private Character input(Scanner scanner) {
        while (true) {
            System.out.print("\nВведите букву: ");
            String input = scanner.nextLine().toUpperCase().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: введено пустое значение!");
                continue;
            }

            char letter = input.charAt(0);

            if (input.length() > 1) {
                System.out.println("Ошибка: введено больше одной буквы!");
                continue;
            }

            if (!Character.isLetter(letter)) {
                System.out.println("Ошибка: требуется ввести букву!");
                continue;
            }

            if (!isCyrillicLetter(letter)) {
                System.out.println("Ошибка: буква не является кириллической!");
                continue;
            }

            if (isAlreadyAttempted(letter)) {
                System.out.println("Ошибка: буква уже была введена!");
                continue;
            }

            return String.valueOf(letter).toUpperCase().charAt(0);
        }
    }

    public static boolean isCyrillicLetter(char ch) {
        return Character.toString(ch).matches("\\p{InCyrillic}");
    }

    private boolean isAlreadyAttempted(char ch) {
        return guessedLetters.contains(ch) || wrongLetters.contains(ch);
    }

    private boolean isGuessedLetter(char ch) {
        return guessedWord.chars().anyMatch(c -> c == ch);
    }

    private void increaseAttemptCount() {
        if (attemptCount < 5) {
            attemptCount++;
        }
    }

    private void decreaseAttemptCount() {
        if (attemptCount > 0) {
            attemptCount--;
        }
    }

    private void increaseStage() {
        if (stage < 5) {
            stage++;
        }
    }

    private void decreaseStage() {
        if (stage > 0) {
            stage--;
        }
    }

    public boolean isGuessedWord() {
        return displayedWord.chars()
                .noneMatch(ch -> ch == '_');
    }
}

