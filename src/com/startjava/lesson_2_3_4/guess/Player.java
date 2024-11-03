package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] guesses = new int[1024];
    private int guessCount = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getGuesses() {
        return Arrays.stream(guesses).filter(guess -> guess != 0).toArray();
    }

    public String getStringGuesses() {
        int[] sliced = Arrays.copyOf(guesses, guessCount);
        StringBuilder sb = new StringBuilder();

        for (int n : sliced) {
            sb.append(n).append(" ");
        }

        return sb.toString().trim();
    }

    public void addGuess(int guess) {
        ++guessCount;
        guesses[guessCount - 1] = guess;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void reset() {
        guessCount = 0;
        Arrays.fill(guesses, 0, guessCount, 0);
    }
}
