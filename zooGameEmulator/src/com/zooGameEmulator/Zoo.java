package com.zooGameEmulator;

import com.consoleCustomPrint.BackgroundColors;
import com.consoleCustomPrint.ConsoleCustomPrint;
import com.consoleCustomPrint.ForegroundColors;
import com.zooGameEmulator.animals.*;

import java.io.BufferedReader;
import java.io.IOException;

/*
 * TODO:
! Create the penguins objects, sanctuary and all about them.
! Create the UndergroundZoo class
 */

public class Zoo {
    private BufferedReader bReader;
    private int visitsCounter = 0;
    private boolean isSpecialTicketOffered = false;
    private final boolean penguin;

    private Bear bearTom;
    private Giraffe giraffeNana;
    private Hippo hippoHellen;
    private Monkey monkeyPlathon;
    private Panther pantherPersia;
    private JavanTiger javaTigerNguyen;

    public Zoo(TicketType ownedTicket, BufferedReader bReader) {
        this.bReader = bReader;
        penguin = ownedTicket == TicketType.ADULT_PENGUIN;

        bearTom = new Bear("Tom", 15);
        giraffeNana = new Giraffe("Nana", 7);
        hippoHellen = new Hippo("Hellen", 4);
        monkeyPlathon = new Monkey("Plathon", 700);
        pantherPersia = new Panther("Persia", 40);
        javaTigerNguyen = new JavanTiger("Nguyen", 17);
    }

    public void enterZoo() throws IOException {
        String userChoice = "";
        String[] animals = {"Oso", "Jirafa", "Hipopotamo", "Mono", "Pantera", "Tigre de Java", "Pingüino"};
        
        ConsoleCustomPrint.printWithColor(ForegroundColors.GREEN, "\nEntras al zoológico y todo parece reluciente. Hay muchas personas pasando por todas partes, vendedores de globos y de comida. Los niños caminan felices, y los padres llevan a sus hijos sobre los hombros.\n", false);
        
        do {
            ConsoleCustomPrint.printWithColor(ForegroundColors.WHITE, "¿Qué animal te gustaría ir a ver? ", true);
            System.out.println("(Escribe el nombre del animal para ir a verlo, o escribe \"salir\" si quieres irte del Zoo)");
            
            for (String animal:animals) {
                System.out.printf("* %s\n", animal);
            }
            
            ConsoleCustomPrint.printWithColor(ForegroundColors.PURPLE, ">> ", true);

            try {
                userChoice = bReader.readLine().toLowerCase();

                switch (userChoice) {
                    case "oso":
                        animalInteractions(bearTom);
                        break;
                    case "jirafa":
                        animalInteractions(giraffeNana);
                        break;
                    case "hipopotamo":
                        animalInteractions(hippoHellen);
                        break;
                    case "mono":
                        animalInteractions(monkeyPlathon);
                        break;
                    case "pantera":
                        animalInteractions(pantherPersia);
                        break;
                    case "tigre de java":
                    case "java":
                        animalInteractions(javaTigerNguyen);
                    case "pingüinos":
                        break;
                    case "salir":
                    System.out.println("Esperamos hayas tenido una buena visita, ¡y te esperamos pronto!");
                        break;
                    default:
                        break;
                }
            } catch (IOException e) {
                ConsoleCustomPrint.exceptionSummary(e);
            }

            if (visitsCounter > 1 && ! isSpecialTicketOffered) {
                isSpecialTicketOffered = true;
                ConsoleCustomPrint.clearScreen();
                ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "Oye amigo... he visto que has estando rondando el zoológico.\n", false);
                ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "¿No buscas algo más... interesante?\n", true);
                ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "¿Comprar ticket especial? (Costo $2200)", false);
                ConsoleCustomPrint.printWithColor(ForegroundColors.WHITE, ">> ", false);
                String buySpecialTicket = bReader.readLine();

                if (buySpecialTicket.equalsIgnoreCase("si") || buySpecialTicket.equalsIgnoreCase("sí")) {
                    ConsoleCustomPrint.printWithColor(BackgroundColors.RED, "\nQue pases un rato", true);

                    for (int i=0;i<3;i++) {
                        try {
                            ConsoleCustomPrint.printWithColor(BackgroundColors.RED, ".", true);
                            Thread.sleep(500);
                        } catch(InterruptedException e) {
                            ConsoleCustomPrint.exceptionSummary(e);
                        }
                    }
                    
                    ConsoleCustomPrint.clearScreen();
                    UndergroundZoo undergroundZoo = new UndergroundZoo();
                    undergroundZoo.goUndergound();
                }
            }

        } while (! userChoice.equalsIgnoreCase("salir"));
    }

    private void animalInteractions(baseAnimal animal) throws IOException {
        animal.readInformationCard();
        ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_DARK, String.format("\n%s\n\n", animal.makeAction()), false);

        ConsoleCustomPrint.printWithColor(ForegroundColors.WHITE, String.format("¿Interactuar con %s?\n", animal.getName()), true);
        ConsoleCustomPrint.printWithColor(ForegroundColors.PURPLE, ">> ", true);

        String interaction = bReader.readLine();

        if (interaction.equalsIgnoreCase("si") || interaction.equalsIgnoreCase("sí")) {
            ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_DARK, String.format("%s\n\n", animal.makeSounds()), false);
        } else {
            System.out.printf("Solo observas en silencio. Miras dentro de %1$s, y %1$s mira dentro de ti.\n\n", animal.getName());
        }

        visitsCounter++;
    }
}
