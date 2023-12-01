package com.terminalClock;

public class MainClock {
    public static void main(String[] args) throws InterruptedException {
        Clock mainClock = new Clock();
        // mainClock.set12HoursClock();

        while (true) {
            System.out.printf(mainClock.getTimeNow());
            Thread.sleep(1000);
        }
    }
}
