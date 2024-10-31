package com.startjava.lesson_2_3_4.method.naming;

import static com.startjava.lesson_2_3_4.method.naming.MethodUtils.getCurrentMethodName;

public class BooleanMethods {

    public boolean isProgramContinuing() {
        System.out.println(getCurrentMethodName() + "() -> программа выполняется далее или завершается?");
        return true;
    }

    public boolean isFileDeleted() {
        System.out.println(getCurrentMethodName() + "() -> удалился ли файл на жестком диске или флешке?");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.println(getCurrentMethodName() + "() -> последовательность содержит уникальную цифру?");
        return true;
    }

    public boolean isLetter() {
        System.out.println(getCurrentMethodName() + "() -> пользователь ввел букву или что-то другое?");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.println(getCurrentMethodName() + "() -> в проверяемых числах, есть равные цифры?");
        return true;
    }

    public boolean hasAttemptsLeft() {
        System.out.println(getCurrentMethodName() + "() -> в игре \"Марио\" остались попытки?");
        return true;
    }

    public boolean isEmpty() {
        System.out.println(getCurrentMethodName() + "() -> пользователь ввёл пустую строку или из одних пробелов?");
        return false;
    }

    public boolean isEvenRoll() {
        System.out.println(getCurrentMethodName() + "() -> на кубике, который бросил компьютер, выпало четное число?");
        return false;
    }

    public boolean isValidFilePath() {
        System.out.println(getCurrentMethodName() + "() -> путь до файла, который вы ищите на ssd, действительный?");
        return true;
    }

    public boolean doesFileExist() {
        System.out.println(getCurrentMethodName() + "() -> файл по указанному адресу существует?");
        return true;
    }
}
