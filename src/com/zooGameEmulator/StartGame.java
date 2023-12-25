package com.zooGameEmulator;

public class StartGame {
    public static void main(String[] args) {
        TicketingSystem welcomeToGame = new TicketingSystem();
        welcomeToGame.startNewGame();

        Zoo zoo = new Zoo(welcomeToGame.getOwnedTicket());
        zoo.enterZoo();
    }
}
