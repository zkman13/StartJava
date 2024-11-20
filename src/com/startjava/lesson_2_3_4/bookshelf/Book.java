package com.startjava.lesson_2_3_4.bookshelf;

public class Book extends AbstractBook {
    private final String bookInfo;

    public Book(final String title, final String author, final int year) {
        super(title, author, year);
        bookInfo = author + ", " + title + ", " + year;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public int getBookInfoLength() {
        return bookInfo.length();
    }
}
