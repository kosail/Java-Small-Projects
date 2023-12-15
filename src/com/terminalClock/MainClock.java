package com.terminalClock;

public class MainClock {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        Clock mainClock = new Clock();
        // mainClock.set12HoursClock();

        while (true) {
            clearScreen();
            System.out.printf(mainClock.getTimeNow());
            Thread.sleep(1000);
        }
    }
}
