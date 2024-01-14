package com.consoleCustomPrint;

public enum BackgroundColors {
    RED("\033[41m"),
    GREEN("\033[42m"),
    YELLOW("\033[43m"),
    BLUE_DARK("\033[44m"),
    BLUE_LIGHT("\033[46m"),
    PURPLE("\033[45m"),
    WHITE("\033[47m"),
    NORMAL("\033[30m");

    private final String bgColor;

    BackgroundColors(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getCode() {
        return bgColor;
    }
}
