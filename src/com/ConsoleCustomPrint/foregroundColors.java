package com.ConsoleCustomPrint;

public enum foregroundColors {
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE_DARK("\033[34m"),
    BLUE_LIGHT("\033[36m"),
    PURPLE("\033[35m"),
    WHITE("\033[37m"),
    NORMAL("\033[30m");
    
    private final String fgColor;

    private foregroundColors(String fgColor) {
        this.fgColor = fgColor;
    }

    public String getCode() {
        return fgColor;
    }
}