package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private final int capacity;
    private Book[] books;
    private int bookCount = 0;
    private int maxBookInfoLength = 0;

    public Bookshelf(final int capacity) {
        this.capacity = capacity;
        books = new Book[capacity];
    }

    public Book[] getBooks() {
        return books;
    }

    public int getMaxBookInfoLength() {
        return maxBookInfoLength;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void addBook(final Book book) {
        books[bookCount] = book;
        bookCount++;
        updateMaxBookInfoLength(book.getBookInfoLength());
    }

    public Book[] findBook(final String title) {
        final int foundBookCount = countBooksByTitle(title);

        return getFoundBooks(foundBookCount, title);
    }

    private int countBooksByTitle(final String title) {
        int foundBookCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                foundBookCount++;
            }
        }

        return foundBookCount;
    }

    private Book[] getFoundBooks(final int foundBookCount, final String title) {
        final Book[] foundBooks = new Book[foundBookCount];

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                foundBooks[i] = books[i];
            }
        }

        return foundBooks;
    }

    public Book[] removeBook(final String title) {
        final Book[] newBooks = new Book[capacity];
        final Book[] removedBooks = new Book[capacity];
        int newBookCount = 0;
        int removedBookCount = 0;

        for (final Book book : books) {
            if (book != null) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    removedBooks[removedBookCount++] = book;
                    bookCount--;
                    continue;
                }

                newBooks[newBookCount++] = book;
            }
        }

        books = newBooks;

        return Arrays.copyOf(removedBooks, removedBookCount);
    }

    public void updateMaxBookInfoLength(int length) {
        if (length > maxBookInfoLength) {
            maxBookInfoLength = length;
        }
    }

    public void clear() {
        books = new Book[capacity];
        bookCount = 0;
    }
}
