package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] guesses;
    private int attempt;

    public Player(String name, int maxGuesses) {
        this.name = name;
        this.guesses = new int[maxGuesses];
    }

    public String getName() {
        return name;
    }

    public int getAttempt() {
        return attempt;
    }

    public int[] getGuesses() {
        return Arrays.copyOf(guesses, attempt);
    }

    public void addGuess(int guess) {
        guesses[attempt++] = guess;
    }

    public void reset() {
        Arrays.fill(guesses, 0, attempt, 0);
        attempt = 0;
    }
}
