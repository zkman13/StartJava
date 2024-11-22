package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private final int capacity;
    private Book[] books;
    private int bookCount = 0;
    private int maxShelfLength = 0;

    public Bookshelf(final int capacity) {
        this.capacity = capacity;
        books = new Book[capacity];
    }

    public Book[] getBooks() {
        return books.clone();
    }

    public int getMaxShelfLength() {
        return maxShelfLength;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void addBook(final Book book) {
        if (bookCount == capacity) {
            throw new IllegalStateException("Нельзя добавить книгу. Книжный шкаф заполнен.");
        }

        books[bookCount++] = book;
        updateMaxShelfLength(book.getBookInfoLength());
    }

    private void updateMaxShelfLength(final int length) {
        maxShelfLength = Math.max(maxShelfLength, length);
    }

    public Book[] findBooks(final String title) {
        final int foundBookCount = countBooks(title);
        return getFoundBooks(foundBookCount, title);
    }

    private int countBooks(final String title) {
        int count = 0;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                count++;
            }
        }

        return count;
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

    public Book[] removeBooks(final String title) {
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
        maxShelfLength = calculateMaxShelfLength();

        return Arrays.copyOf(removedBooks, removedBookCount);
    }

    private int calculateMaxShelfLength() {
        return Arrays
                .stream(Arrays.copyOfRange(books, 0, bookCount))
                .mapToInt(Book::getBookInfoLength)
                .reduce(0, Integer::max);
    }

    public void clear() {
        Arrays.fill(books, null);
        bookCount = 0;
    }
}
