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

    public String getStringGuesses() {
        int[] nums = getGuesses();
        StringBuilder sb = new StringBuilder();

        for (int n : nums) {
            sb.append(n).append(" ");
        }

        return sb.toString().trim();
    }

    public int[] getGuesses() {
        return Arrays.copyOf(guesses, guessCount);
    }

    public void addGuess(int guess) {
        guessCount++;
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
