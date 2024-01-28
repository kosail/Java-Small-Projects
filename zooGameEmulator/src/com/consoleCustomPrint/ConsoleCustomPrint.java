package com.consoleCustomPrint;

public class ConsoleCustomPrint {
    private static final String boldText = "\033[1m";
    private static final String cleanFormat = "\033[0m";
    
    public static void printWithColor(ForegroundColors color, String text, boolean isBoldText) {
        if (isBoldText) {
            System.out.printf("%s%s%s%s", color.getCode(), boldText, text, cleanFormat);
        } else {
            System.out.printf("%s%s%s", color.getCode(), text, cleanFormat);
        }
    }

    public static void printWithColor(BackgroundColors color, String text, boolean isBoldText) {
        if (isBoldText) {
            System.out.printf("%s%s%s%s", color.getCode(), boldText, text, cleanFormat);
        } else {
            System.out.printf("%s%s%s", color.getCode(), text, cleanFormat);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearScreen(int timer) {
        try {
            Thread.sleep(timer);
            clearScreen();
        } catch (InterruptedException e) {
            exceptionSummary(e);
        }
    }

    public static void exceptionSummary(Exception e) {
        System.out.print("An error has occurred with an exception type of ");
        printWithColor(ForegroundColors.RED, String.format("%s\n", e.getClass()).substring(6), true);

        System.out.print("Cause of exception: ");
        printWithColor(ForegroundColors.YELLOW, String.format("%s\n\n", e.getMessage()), true);
        
        printWithColor(ForegroundColors.BLUE_DARK, "Stack Trace:\n", true);
        e.printStackTrace();
    }
}
