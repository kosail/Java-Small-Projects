package com.zooGameEmulator;

import com.consoleCustomPrint.ConsoleCustomPrint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StartGame {
    public static void main(String[] args) {

        try (BufferedReader sharedBuffer = new BufferedReader(new InputStreamReader(System.in))) {
            TicketingSystem welcomeToGame = new TicketingSystem(sharedBuffer);
            welcomeToGame.startNewGame();

            Zoo zoo = new Zoo(welcomeToGame.getOwnedTicket(), sharedBuffer);
            zoo.enterZoo();

        } catch (IOException e) {
            ConsoleCustomPrint.exceptionSummary(e);
        }

    }
}
