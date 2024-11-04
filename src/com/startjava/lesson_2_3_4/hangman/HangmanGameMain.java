package com.startjava.lesson_2_3_4.hangman;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameMain {

    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame(getWords());
        hangmanGame.play();
    }

    private static List<String> getWords() {
        List<String> words = new ArrayList<>();

        words.add("компьютер");
        words.add("путешествие");
        words.add("исследование");
        words.add("фотография");
        words.add("информация");
        words.add("энциклопедия");
        words.add("архитектура");
        words.add("библиотека");
        words.add("путеводитель");
        words.add("программирование");

        return words;
    }
}
