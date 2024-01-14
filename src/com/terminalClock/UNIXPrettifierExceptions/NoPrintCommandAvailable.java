package com.terminalClock.UNIXPrettifierExceptions;

import java.io.IOException;

public class NoPrintCommandAvailable extends IOException {
    public NoPrintCommandAvailable() {
        super("There is no such command as figlet or toilet installed in the system!");
    }
}
