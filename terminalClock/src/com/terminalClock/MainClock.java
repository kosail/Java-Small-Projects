package com.terminalClock;

public class MainClock {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        Clock mainClock = new Clock();
        UNIXCLIPrettifier unixP = new UNIXCLIPrettifier();
        
        mainClock.set12HoursClock();
        unixP.setMetalColors();

        while (true) {
            clearScreen();
            unixP.UNIXPrettyPrinter(mainClock.getTimeNow());
            Thread.sleep(990);
        }
    }
}
