package com.zooGameEmulator;

enum printerForegroundColors {
    FG_RED("\033[31m"),
    FG_GREEN("\033[32m"),
    FG_YELLOW("\033[33m"),
    FG_BLUE_DARK("\033[34m"),
    FG_BLUE_LIGHT("\033[36m"),
    FG_PURPLE("\033[35m"),
    FG_WHITE("\033[37m");
    
    private final String fgColor;

    private printerForegroundColors(String fgColor) {
        this.fgColor = fgColor;
    }

    public String getCode() {
        return fgColor;
    }
}

enum printerBackgroundColors {
    BG_RED("\033[41m"),
    BG_GREEN("\033[42m"),
    BG_YELLOW("\033[43m"),
    BG_BLUE_DARK("\033[44m"),
    BG_BLUE_LIGHT("\033[46m"),
    BG_PURPLE("\033[45m"),
    BG_WHITE("\033[47m");

    private final String bgColor;

    private printerBackgroundColors(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getCode() {
        return bgColor;
    }
}

public class ConsoleCustomPrinter {
    String boldLetter = "\033[1m";
    String destroyFormat = "\033[0m";

    public static void printWithColor() {
        System.out.printf("%s%s");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
