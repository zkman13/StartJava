package com.startjava.lesson_2_3.method.naming;

public class ClassNaming {

    public static void main(String[] args) {
        execNonBooleanMethods();
        System.out.println("\n");
        execBooleanMethods();
    }

    private static void execNonBooleanMethods() {
        NonBooleanMethods nonBm = new NonBooleanMethods();

        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.calculateAvg();
        nonBm.countUniqueWords();
        nonBm.printErrorMessage();
        nonBm.syncData();
        nonBm.restoreData();
        nonBm.pauseDownload();
        nonBm.resetSettings();
        nonBm.writeToFile();
        nonBm.convertToFahrenheit();
        nonBm.inputMathExpression();
        nonBm.determineRaceWinner();
        nonBm.findBookByAuthor();
    }

    private static void execBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();

        System.out.println(bm.isProgramContinuing());
        System.out.println(bm.isFileDeleted());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasAttemptsLeft());
        System.out.println(bm.isEmpty());
        System.out.println(bm.isEvenRoll());
        System.out.println(bm.isValidFilePath());
        System.out.println(bm.doesFileExist());
    }
}
