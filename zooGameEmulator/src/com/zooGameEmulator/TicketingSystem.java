package com.zooGameEmulator;

import java.io.BufferedReader;
import java.io.IOException;

import com.consoleCustomPrint.ConsoleCustomPrint;
import com.consoleCustomPrint.BackgroundColors;
import com.consoleCustomPrint.ForegroundColors;

public class TicketingSystem {
    private TicketType newTicket = null;
    private final BufferedReader bReader;
    
    public TicketingSystem(BufferedReader bReader) {
        this.bReader = bReader;
    }
    
    public void startNewGame() {
        ConsoleCustomPrint.printWithColor(BackgroundColors.BLUE_LIGHT,
                "¡Bienvenido al zoológico virtual de Ciudad Sierra!\n", true);
        ConsoleCustomPrint.printWithColor(ForegroundColors.NORMAL, "+------------------------------------------------+\n",
                true);
        
        System.out.println("Estas son nuestras tarifas:");
        System.out.printf(
                "\t* Adulto: $%d\n\t* Adulto + Acceso al santuario de Pingüinos: $%d\n\t* Niños menores de 12 años: $%d\n\n",
                TicketType.ADULT_BASIC.getTicketPrice(), TicketType.ADULT_PENGUIN.getTicketPrice(),
                TicketType.KID.getTicketPrice()
        );
        
        boolean validChoose = false;
        
        do {
            try {
                ConsoleCustomPrint.printWithColor(ForegroundColors.YELLOW, "¿Deseas comprar un ticket?\n", true);
                System.out.println("\t1) Sí\n\t2) No");
                ConsoleCustomPrint.printWithColor(ForegroundColors.WHITE, ">> ", true);
                int buyTicket = Integer.parseInt(bReader.readLine());
                
                if (buyTicket != 1) {
                    exitGame();
                } else {
                    int desiredTicket;
                    
                    ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_LIGHT, "¿Qué tipo de ticket quieres comprar?\n",  true);
                    System.out.println("\t 1) Adulto\n\t 2) Adulto + Acceso al santuario de Pingüinos\n\t 3) Niños menores de 12 años");
                    ConsoleCustomPrint.printWithColor(ForegroundColors.WHITE, ">> ", true);
                    
                    desiredTicket = Integer.parseInt(bReader.readLine());
                    
                    switch (desiredTicket) {
                        case 1:
                            newTicket = TicketType.ADULT_BASIC;
                            validChoose = true;
                            break;
                        case 2:
                            newTicket = TicketType.ADULT_PENGUIN;
                            validChoose = true;
                            break;
                        case 3:
                            newTicket = TicketType.KID;
                            validChoose = true;
                            break;
                        default:
                            ConsoleCustomPrint.clearScreen();
                            ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "Ingresaste una opción no valida.\n", true);
                    }
                    
                    
                    ConsoleCustomPrint.printWithColor(ForegroundColors.GREEN,
                            "¡Compra exitosa! Disfruta de tu visita al Zoológico de Ciudad Sierra.\n", true);
                    ConsoleCustomPrint.clearScreen(1800);
                    
                }
                
            } catch (IOException e) {
                ConsoleCustomPrint.exceptionSummary(e);
            } catch (NumberFormatException e) {
                ConsoleCustomPrint.clearScreen();
                ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "Ingresaste una opción no valida.\n", true);
            }
        } while (!validChoose);
    }
    
    TicketType getOwnedTicket() {
        return newTicket;
    }
    
    private void exitGame() {
        System.out.println("¡Esperamos vuelvas pronto!");
        System.exit(0);
    }
}
