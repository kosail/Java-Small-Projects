package com.terminalClock;

import com.consoleCustomPrint.ConsoleCustomPrint;
import com.consoleCustomPrint.ForegroundColors;

public class MainClock {

    public static void main(String[] args) throws InterruptedException {
        
        if (args.length == 0 || args.length > 3) {
            usageManual.invalidArguments();
        }
        
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help")) {
                usageManual.getUsage();
            } else {
                usageManual.invalidArguments();
            }
        }
        
        Clock mainClock = new Clock();
        
        if (args.length >= 2) {
            if (args[1].equals("-12")) {
                mainClock.set12HoursClock();
            }
        }
        
        if (args[0].equalsIgnoreCase("-windows")) {
            while (true) {
                ConsoleCustomPrint.clearScreen();
                System.out.println(mainClock.getTimeNow());
                Thread.sleep(990);
            }
            
        } else if (args[0].equalsIgnoreCase("-unix")) {
            UNIXCLIPrettifier unixP = new UNIXCLIPrettifier();

            if (args.length == 3) {
                if (args[2].equalsIgnoreCase("-metal")) {
                    unixP.setMetalColors();
                } else if (args[2].equalsIgnoreCase("-rainbow")) {
                    unixP.setGayColors();
                }
            }
            
            while (true) {
                ConsoleCustomPrint.clearScreen();
                unixP.UNIXPrettyPrinter(mainClock.getTimeNow());
                Thread.sleep(990);
            }
        }
    }
}
