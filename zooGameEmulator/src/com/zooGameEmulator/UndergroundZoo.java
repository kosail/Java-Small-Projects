package com.zooGameEmulator;

import java.io.BufferedReader;
import java.io.IOException;

import com.consoleCustomPrint.ConsoleCustomPrint;
import com.consoleCustomPrint.ForegroundColors;
import com.zooGameEmulator.animals.special.*;

public class UndergroundZoo {
    private BufferedReader bReader;
    private Zoo mainZoo;
    private Clinkshiver clinkShiverShiberuq;
    private MeltingAnimal meltingAnimalMelthraumm;
    private Saya sayaSaya;
    private Shadethread shadethreadHrimthade;

    public UndergroundZoo(BufferedReader bReader, Zoo mainZoo) {
        this.bReader = bReader;
        this.mainZoo = mainZoo;

        clinkShiverShiberuq = new Clinkshiver("Shiberuq", 79);
        meltingAnimalMelthraumm = new MeltingAnimal("Melthraumm", 412);
        sayaSaya = new Saya("Saya", 21);
        shadethreadHrimthade = new Shadethread("Hrimthade", 706);
    }

    void enterUndergroundZoo() throws IOException {
        ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_DARK, "Sigues al hombre a lo largo de diversos pasillos hasta terminar frente a una puerta semiabierta. La oscuridad se extiende profunda e impenetrable, pero alcanzas a ver que a pocos pies de la puerta se extienden escaleras hasta la oscuridad.\n", false);
        ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "No te los quites... a menos que quieras cambiar de rol con \"ellos\".\n", true);
        System.out.println("Te extiende unos sencillos auriculares para suprimir el sonido.\n¿Entrar?");
        ConsoleCustomPrint.printWithColor(ForegroundColors.RED, ">> ", true);
        String goUnderground = bReader.readLine();
        
        if (! goUnderground.equalsIgnoreCase("si") && ! goUnderground.equalsIgnoreCase("sí")) {
            return;
        } else {
            ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_DARK, "Entras y bajas las escaleras. Apenas unos pocos metros dentro las escaleras comienzan a iluminarse con pequeñas farolas.\n", false);
            System.out.println("Antes de pensarlo, ya has llegado a un pasillo muy bien iluminado y que tiene más visitantes de lo que esperabas. Se miran personas extrañas. Unos toman notas mientras miran curiosos; otros, sonrien y charlan entre ellos. De cualquier manera, nadie parece preocupado por ti.\n");

            int userChoice = 0;
            String[] animals = {"???", "???", "???", "???"};

            do {
                ConsoleCustomPrint.printWithColor(ForegroundColors.WHITE, "¿Qué animal te gustaría ir a ver?\n", true);
                System.out.println("(Escribe el número de celda del animal para ir a verlo, o escribe \"0\" si quieres irte de este lugar.)");
                
                for (int i=0; i<animals.length;i++) {
                    System.out.printf("%d.- %s\n", i + 1, animals[i]);
                }
                
                ConsoleCustomPrint.printWithColor(ForegroundColors.PURPLE, ">> ", true);

                try {
                    userChoice = Integer.parseInt(bReader.readLine());

                    switch (userChoice) {
                        case 1:
                            mainZoo.animalInteractions(clinkShiverShiberuq);
                            animals[0] = "ClinkShiver";
                            break;
                        case 2:
                            mainZoo.animalInteractions(meltingAnimalMelthraumm);
                            animals[1] = "Bestia derretida";
                            break;
                        case 3:
                            mainZoo.animalInteractions(sayaSaya);
                            animals[2] = "Saya";
                            break;
                        case 4:
                            mainZoo.animalInteractions(shadethreadHrimthade);
                            animals[3] = "ShadeThread";
                            break;
                        case 0:
                            ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_DARK, "Dejas el lugar sin mirar hacia atras.", false);
                            ConsoleCustomPrint.clearScreen(1500);
                            break;
                        default:
                            break;
                    }
                } catch (IOException | NumberFormatException e) {
                    ConsoleCustomPrint.exceptionSummary(e);
                }
            } while (userChoice != 0);
        }
    }
}
