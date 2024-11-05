package com.startjava.lesson_2_3_4.hangman;

import java.util.List;

public class HangmanGameMain {

    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame(getWords());
        hangmanGame.play();
    }

    private static String[] getWords() {
        return new String[]{
                "компьютер",
                "путешествие",
                "исследование",
                "фотография",
                "информация",
                "энциклопедия",
                "архитектура",
                "библиотека",
                "путеводитель",
                "программирование",
        };
    }
}
