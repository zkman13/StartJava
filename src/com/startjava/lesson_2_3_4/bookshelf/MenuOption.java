package com.startjava.lesson_2_3_4.bookshelf;

public enum MenuOption {

    ADD_BOOK("Добавить книгу"),
    FIND_BOOK("Найти книгу"),
    REMOVE_BOOK("Удалить книгу"),
    CLEAR_BOOKSHELF("Очистить шкаф"),
    EXIT("Завершить");

    private final String description;

    MenuOption(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
