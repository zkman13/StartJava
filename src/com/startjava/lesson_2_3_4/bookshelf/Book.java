package com.startjava.lesson_2_3_4.bookshelf;

public class Book {

    private final BookDetails details;
    private final String bookInfo;

    public Book(final String title, final String author, final int year) {
        details = new BookDetails(title, author, year);
        bookInfo = author + ", " + title + ", " + year;
    }

    public String getTitle() {
        return details.title();
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public int getBookInfoLength() {
        return bookInfo.length();
    }
}