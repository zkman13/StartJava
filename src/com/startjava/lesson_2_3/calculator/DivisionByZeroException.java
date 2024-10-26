package com.startjava.lesson_2_3.calculator;

public class DivisionByZeroException extends ArithmeticException {

    public DivisionByZeroException(String message) {
        super(message);
    }
}
