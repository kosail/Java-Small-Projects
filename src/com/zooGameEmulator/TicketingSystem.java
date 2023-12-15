package com.zooGameEmulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicketingSystem {
    private TicketType newTicket = null;

    public void startNewGame() {
        System.out.println("¡Bienvenido al zoológico virtual de Ciudad Sierra!");
        System.out.println("+------------------------------------------------+");
        System.out.println("Estas son nuestras tarifas:");
        System.out.printf("\t* Adulto: $%d\n\t* Adulto + Acceso al santuario de Pingüinos: $%d\n\t* Niños menores de 12 años: $%d\n\n", TicketType.ADULT_BASIC.getTicketPrice(), TicketType.ADULT_PENGUIN.getTicketPrice(), TicketType.KID.getTicketPrice());

        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("\033[33m\033[1m¿Deseas comprar un ticket?\033[0m\n\t1) Sí\n\t2) No\n>> ");
            int buyTicket = Integer.parseInt(br.readLine());
            
            if (buyTicket == 1) {
                boolean validChoose = false;
                int desiredTicket = 0;

                do {                    
                    System.out.println("\033[1m¿Qué tipo de ticket quieres comprar?\033[0m\n\t 1) Adulto\n\t 2) Adulto + Acceso al santuario de Pingüinos\n\t 3) Niños menor de 12 años");
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
                            ConsoleCustomPrinter.clearScreen();
                            System.out.println("\033[31m\033[1m  Ingresaste una opción no valida.\033[0m");
                            break;
                    }
                } while (!validChoose);
                    
                System.out.println("¡Compra exitosa! Disfruta de tu visita al Zoológico de Ciudad Sierra.");
                
            } else {
                System.out.println("Esperamos vuelvas pronto.");
                exitGame();
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public TicketType getOwnedTicket() {
        return newTicket;
    }

    private void exitGame() {
        System.exit(0);
    }
}
