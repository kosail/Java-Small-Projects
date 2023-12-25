package com.zooGameEmulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ConsoleCustomPrint.ConsoleCustomPrint;
import com.ConsoleCustomPrint.backgroundColors;
import com.ConsoleCustomPrint.foregroundColors;

public class TicketingSystem {
    private TicketType newTicket = null;

    public void startNewGame() {
        ConsoleCustomPrint.printWithColor(backgroundColors.BLUE_LIGHT, "¡Bienvenido al zoológico virtual de Ciudad Sierra!\n", true);
        ConsoleCustomPrint.printWithColor(foregroundColors.NORMAL, "+------------------------------------------------+\n", true);
        System.out.println("Estas son nuestras tarifas:");
        System.out.printf("\t* Adulto: $%d\n\t* Adulto + Acceso al santuario de Pingüinos: $%d\n\t* Niños menores de 12 años: $%d\n\n", TicketType.ADULT_BASIC.getTicketPrice(), TicketType.ADULT_PENGUIN.getTicketPrice(), TicketType.KID.getTicketPrice());
        
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ConsoleCustomPrint.printWithColor(foregroundColors.YELLOW, "¿Deseas comprar un ticket?\n", true);
            System.out.println("\t1) Sí\n\t2) No");
            ConsoleCustomPrint.printWithColor(foregroundColors.WHITE, ">> ", true);

            int buyTicket = Integer.parseInt(br.readLine());
            
            if (buyTicket == 1) {
                boolean validChoose = false;
                int desiredTicket = 0;
                
                do {
                    ConsoleCustomPrint.printWithColor(foregroundColors.BLUE_LIGHT, "¿Qué tipo de ticket quieres comprar?\n", true);             
                    System.out.println("\t 1) Adulto\n\t 2) Adulto + Acceso al santuario de Pingüinos\n\t 3) Niños menor de 12 años");
                    ConsoleCustomPrint.printWithColor(foregroundColors.WHITE, ">> ", true);

                    desiredTicket = Integer.parseInt(br.readLine());
                    
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
                            ConsoleCustomPrint.printWithColor(foregroundColors.RED, "Ingresaste una opción no valida.\n", true);
                            break;
                    }
                } while (!validChoose);
                
                ConsoleCustomPrint.printWithColor(foregroundColors.GREEN, "¡Compra exitosa! Disfruta de tu visita al Zoológico de Ciudad Sierra.\n", true);
                ConsoleCustomPrint.clearScreen(1800);           
            } else {
                System.out.println("Esperamos vuelvas pronto.");
                exitGame();
            }

        } catch (IOException e) {
            ConsoleCustomPrint.exceptionSummary(e);

        } catch (NumberFormatException e) {
            ConsoleCustomPrint.exceptionSummary(e);
        }
    }

    public TicketType getOwnedTicket() {
        return newTicket;
    }

    private void exitGame() {
        System.exit(0);
    }
}
