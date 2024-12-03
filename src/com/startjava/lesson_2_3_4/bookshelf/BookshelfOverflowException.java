package com.startjava.lesson_2_3_4.bookshelf;

public class BookshelfOverflowException extends IllegalStateException {

    public BookshelfOverflowException(String message) {
        super(message);
    }
}
