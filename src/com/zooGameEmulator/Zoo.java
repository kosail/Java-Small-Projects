package com.zooGameEmulator;

import com.ConsoleCustomPrint.ConsoleCustomPrint;
import com.ConsoleCustomPrint.foregroundColors;
import com.zooGameEmulator.animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {
    private BufferedReader bReader;
    private final boolean penguin;

    private Bear bearTom;
    private Giraffe giraffeNana;
    private Hippo hippoHellen;
    private Monkey monkeyPlathon;
    private Panther pantherPersia;

    public Zoo(TicketType ownedTicket, BufferedReader bReader) {
        this.bReader = bReader;
        penguin = ownedTicket == TicketType.ADULT_PENGUIN;

        bearTom = new Bear("Tom", 15);
        giraffeNana = new Giraffe("Nana", 7);
        hippoHellen = new Hippo("Hellen", 4);
        monkeyPlathon = new Monkey("Plathon", 700);
        pantherPersia = new Panther("Persia", 40);
    }

    public void enterZoo() {
        String userChoice = "";
        String[] animals = {"Oso", "Jirafa", "Hipopotamo", "Mono", "Pantera", "Pingüino"};
        
        System.out.println("Entras al zoológico y todo parece reluciente. Hay muchas personas pasando por todas partes, vendedores de globos y de comida. Los niños caminan felices, y los padres llevan a sus hijos sobre los hombros.");
        
        do {
            ConsoleCustomPrint.printWithColor(foregroundColors.WHITE, "¿Qué animal te gustaría ir a ver? ", true);
            System.out.println("(Escribe el nombre del animal para ir a verlo, o escribe \"salir\" si quieres irte del Zoo)");
            
            for (String animal:animals) {
                System.out.printf("* %s\n", animal);
            }
            
            ConsoleCustomPrint.printWithColor(foregroundColors.PURPLE, ">> ", true);

            try {
                userChoice = bReader.readLine().toLowerCase();

                switch (userChoice) {
                    case "oso":
                        break;
                    case "jirafa":
                        break;
                    case "hipopotamo":
                        break;
                    case "mono":
                        break;
                    case "pantera":
                        break;
                    case "pingüinos":
                        break;
                    case "salir":
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                ConsoleCustomPrint.exceptionSummary(e);
            }

        } while (! userChoice.equalsIgnoreCase("salir"));
    }
}
