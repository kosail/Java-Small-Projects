package com.terminalClock;

import java.io.IOException;

import com.consoleCustomPrint.ConsoleCustomPrint;
import com.terminalClock.UNIXPrettifierExceptions.NoPrintCommandAvailable;

public class UNIXCLIPrettifier {
    ProcessBuilder pb;
    private String commandToUse = "", color="";
    
    public UNIXCLIPrettifier() {
        try {
            pb = new ProcessBuilder();
            
            if (pb.command("/bin/sh", "-c", "figlet -v").start().waitFor() == 0) {
                commandToUse = "figlet";
            } else if (pb.command("/bin/sh", "-c", "toilet -v").start().waitFor() == 0) {
                commandToUse = "toilet";
            } else {
                throw new NoPrintCommandAvailable();
            }

            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            
        } catch (IOException | InterruptedException e) {
            ConsoleCustomPrint.exceptionSummary(e);
        }
    }

    void setGayColors() {
        color = "--gay";
    }

    void setMetalColors() {
        color = "--metal";
    }

    void UNIXPrettyPrinter(String stringToPrint) {
        String[] parser = stringToPrint.split("\n");
        String timeFullCommand = String.format("%s -f mono9 %s %s", commandToUse, color, parser[0]);
        String timezoneFullCommand = String.format("%s -f smbraille %s %s", commandToUse, color, parser[1]);
        
        try {
            Process process = pb.command("/bin/sh", "-c", timeFullCommand).start();
            process.waitFor();
            
            process = pb.command("/bin/sh", "-c", timezoneFullCommand).start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            ConsoleCustomPrint.exceptionSummary(e);
        }
    }
}