package com.startjava.lesson_2_3_4.bookshelf;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class BookshelfMain {

    private static final int CAPACITY = 10;
    private static final int MIN_PUBLICATION_YEAR = 1400;
    private static final int MAX_PUBLICATION_YEAR = LocalDate.now().getYear() + 1;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Bookshelf bookshelf = new Bookshelf(CAPACITY);
        renderWelcomeMsg();

        while (true) {
            final boolean isBookshelfEmpty = bookshelf.getBookCount() == 0;
            final boolean isBookshelfFull = bookshelf.getBookCount() == CAPACITY;
            final MenuOption[] menuOptions = getMenuOptions(isBookshelfEmpty, isBookshelfFull);
            renderMenu(menuOptions);
            final int menuOptionNumber = inputMenuOption(scanner, menuOptions.length);
            final MenuOption option = menuOptions[menuOptionNumber - 1];
            renderMenuSelection(option);
            int exitCode = execMenuOption(option, bookshelf, scanner);

            if (exitCode == 1) {
                break;
            }

            final int freeShelfCount = CAPACITY - bookshelf.getBookCount();
            renderBookshelfInfo(bookshelf.getBookCount(), freeShelfCount);
            renderBookshelf(bookshelf);
            waitForEnterToContinue(scanner);
        }

        scanner.close();
    }

    private static void renderWelcomeMsg() {
        System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу\n");
    }

    private static MenuOption[] getMenuOptions(
            final boolean isBookshelfEmpty,
            final boolean isBookshelfFull) {
        if (isBookshelfEmpty) {
            return new MenuOption[]{MenuOption.ADD_BOOK, MenuOption.EXIT};
        }

        if (isBookshelfFull) {
            return new MenuOption[]{MenuOption.FIND_BOOK, MenuOption.REMOVE_BOOK,
                    MenuOption.CLEAR_BOOKSHELF, MenuOption.EXIT};
        }

        return MenuOption.values();
    }

    private static void renderMenu(final MenuOption[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s%n", i + 1, options[i].getDescription());
        }

        System.out.println();
    }

    private static int inputMenuOption(final Scanner scanner, final int menuSize) {
        while (true) {
            try {
                System.out.print("[Введите номер пункта меню]: ");
                final int option = scanner.nextInt();

                if (option >= 1 && option <= menuSize) {
                    scanner.nextLine();
                    System.out.println();

                    return option;
                }

                System.out.printf("Ошибка: необходимо ввести число от 1 до %d%n", menuSize);
            } catch (RuntimeException e) {
                System.out.println("Ошибка: необходимо ввести целое число");
                scanner.nextLine();
            }
        }
    }

    private static void renderMenuSelection(final MenuOption option) {
        if (option == MenuOption.EXIT) {
            System.out.printf("→ Вы выбрали: %s%n", option.getDescription());
        } else {
            System.out.printf("→ Вы выбрали: %s%n%n", option.getDescription());
        }
    }

    private static int execMenuOption(
            final MenuOption option,
            final Bookshelf bookshelf,
            final Scanner scanner) {
        switch (option) {
            case ADD_BOOK -> addBook(bookshelf, scanner);
            case FIND_BOOK -> findBook(bookshelf, scanner);
            case REMOVE_BOOK -> removeBook(bookshelf, scanner);
            case CLEAR_BOOKSHELF -> clearBookshelf(bookshelf);
            case EXIT -> {
                return 1;
            }
            default -> throw new RuntimeException("Неизвестный пункт меню");
        }

        return 0;
    }

    private static void addBook(final Bookshelf bookshelf, final Scanner scanner) {
        final BookDetails bookDetails = collectBookInfo(scanner);
        final Book book = new Book(bookDetails.title(), bookDetails.author(), bookDetails.year());
        bookshelf.addBook(book);
        System.out.println("\n> Книга добавлена\n");
    }

    private static BookDetails collectBookInfo(final Scanner scanner) {
        final String author = inputAuthor(scanner);
        final String title = inputTitle(scanner);
        final Year year = Year.of(inputYear(scanner));

        return new BookDetails(title, author, year);
    }

    private static String inputAuthor(final Scanner scanner) {
        while (true) {
            System.out.print("[Введите автора книги]: ");
            final String author = scanner.nextLine().trim();

            if (author.isEmpty()) {
                System.out.println("Ошибка: имя автора не может быть пустым");
                continue;
            }

            return author;
        }
    }

    private static int inputYear(final Scanner scanner) {
        while (true) {
            try {
                System.out.print("[Введите год издания книги]: ");
                final int year = Integer.parseInt(scanner.nextLine().trim());

                if (year < MIN_PUBLICATION_YEAR) {
                    System.out.printf("Ошибка: год издания не может быть меньше 1400%n");
                    continue;
                }

                if (year > MAX_PUBLICATION_YEAR) {
                    System.out.printf("Ошибка: год издания не может быть больше %d%n", MAX_PUBLICATION_YEAR);
                    continue;
                }

                return year;
            } catch (RuntimeException e) {
                System.out.println("Ошибка: необходимо ввести целое число");
            }
        }
    }

    private static void findBook(final Bookshelf bookshelf, final Scanner scanner) {
        final String title = inputTitle(scanner);
        final Book[] founded = bookshelf.findBooks(title);
        renderFoundedBooks(founded, title);
    }

    private static void renderFoundedBooks(final Book[] books, final String title) {
        if (books.length == 0) {
            System.out.printf("Книги с названием \"%s\" не найдены%n%n", title);
            return;
        }

        renderBookList("Найденные книги:", books);
        System.out.println();
    }

    private static void removeBook(final Bookshelf bookshelf, final Scanner scanner) {
        final String title = inputTitle(scanner);
        final Book[] removedBooks = bookshelf.removeBooks(title);
        renderRemovedBooks(removedBooks, title);
    }

    private static String inputTitle(final Scanner scanner) {
        while (true) {
            System.out.print("[Введите название книги]: ");
            final String title = scanner.nextLine().trim();

            if (title.isEmpty()) {
                System.out.println("Ошибка: название книги не может быть пустым");
                continue;
            }

            return title;
        }
    }

    private static void renderRemovedBooks(final Book[] books, final String title) {
        if (books.length == 0) {
            System.out.printf("Книги с названием \"%s\" не найдены%n%n", title);
            return;
        }

        renderBookList("Удалённые книги:", books);
        System.out.println();
    }

    private static void renderBookList(final String message, final Book[] books) {
        System.out.printf("%n%s%n", message);

        for (int i = 0; i < books.length; i++) {
            final Book book = books[i];

            if (book == null) break;

            System.out.printf("%d. %s%n", i + 1, book.getBookInfo());
        }
    }

    private static void clearBookshelf(final Bookshelf bookshelf) {
        bookshelf.clear();
        System.out.println("> Книжный шкаф очищен\n");
    }

    private static void renderBookshelfInfo(final int bookCount, final int freeShelfCount) {
        System.out.printf("В шкафу книг - %d, свободно полок - %d%n%n", bookCount, freeShelfCount);
    }

    private static void renderBookshelf(final Bookshelf bookshelf) {
        final Book[] books = bookshelf.getBooks();
        final int bookCounter = bookshelf.getBookCount();
        final int maxShelfLength = bookshelf.getMaxShelfLength();

        renderFullShelf(books, bookCounter, maxShelfLength);
        renderEmptyShelf(bookCounter, maxShelfLength);
        System.out.println();
    }

    private static void renderFullShelf(
            final Book[] books,
            final int bookCounter,
            final int maxShelfLength
    ) {
        for (int i = 0; i < bookCounter; i++) {
            final StringBuilder sb = new StringBuilder();
            final Book book = books[i];

            if (i == 0) {
                buildLine(sb, maxShelfLength);
                sb.append("\n");
            }

            final int freeSpaceCounter = maxShelfLength - book.getBookInfoLength();
            buildBookInfoLine(sb, book.getBookInfo(), freeSpaceCounter);
            buildLine(sb, maxShelfLength);
            System.out.println(sb);
        }
    }

    private static void buildLine(final StringBuilder sb, final int maxShelfLength) {
        sb
                .append("|")
                .append("-".repeat(maxShelfLength))
                .append("|");
    }

    private static void buildBookInfoLine(
            final StringBuilder sb,
            final String bookInfo,
            final int freeSpaceCounter) {
        sb
                .append("|")
                .append(bookInfo)
                .append(" ".repeat(freeSpaceCounter))
                .append("|\n");
    }

    private static void renderEmptyShelf(
            final int bookCounter,
            final int maxShelfLength
    ) {
        final int emptyShelfCounter = CAPACITY - bookCounter;

        for (int i = 0; i < emptyShelfCounter; i++) {
            final StringBuilder sb = new StringBuilder();

            if (i == 0 && bookCounter == 0) {
                buildLine(sb, maxShelfLength);
                sb.append("\n");
            }

            buildShelfBase(sb, maxShelfLength);
            System.out.println(sb);
        }
    }

    private static void buildShelfBase(final StringBuilder sb, final int maxShelfLength) {
        sb
                .append("|")
                .append(" ".repeat(maxShelfLength))
                .append("|\n")
                .append("|")
                .append("-".repeat(maxShelfLength))
                .append("|");
    }

    private static void waitForEnterToContinue(final Scanner scanner) {
        while (true) {
            System.out.println("Для продолжения работы нажмите клавишу <Enter>");
            final String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }
        }
    }
}

