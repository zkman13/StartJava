package com.startjava.lesson_2_3_4.bookshelf;

public class AbstractBook {

    protected String title;
    protected String author;
    protected int year;

    public AbstractBook(final String title, final String author, final int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
