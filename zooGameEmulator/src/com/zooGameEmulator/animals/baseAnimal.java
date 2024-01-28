package com.zooGameEmulator.animals;

import com.consoleCustomPrint.*;

public abstract class baseAnimal {
    private String name, scientificName,details;
    private int age;

    public baseAnimal(String name, String scientificName, String details, int age) {
        this.name = name;
        this.scientificName = scientificName;
        this.age = age;
        this.details = details;
    }

    public void readInformationCard() {
        ConsoleCustomPrint.printWithColor(BackgroundColors.YELLOW, String.format("%10s%s%10s\n","", name.toUpperCase(), ""), true);
        
        ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "Nombre científico: ", false);
        System.out.println(scientificName);
        
        ConsoleCustomPrint.printWithColor(ForegroundColors.GREEN, "Edad de este ejemplar: ", false);
        System.out.println(age);
        
        ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_LIGHT, "Información sobre este animal:", false);
        System.out.println(details);
    }

    public String getName() {
        return this.name;
    }

    public abstract String makeSounds();
    public abstract String makeAction();

    public String randomAction() {
        return randomActionGenerator((int) (Math.random() * 10));
    }
    
    private String randomActionGenerator(int randomAction) {
        switch (randomAction) {
            case 0:
                return "...";
            case 1:
                return name + " hace una voltereta y le guiña un ojo a los visitantes.";
            case 2:
                return name + " comienza a bailar breakdance inesperadamente, impresionando a todos alrededor.";
            case 3:
                return name + " finge ser un superhéroe, secuestra a un niño de entre la gente y lo salva él mismo.";
            case 4:
                return name + " comienza a hacer standup... está haciendo chiste sobre el personal de hoteles.";
            case 5:
                return name + " agarra un micrófono y comienza a cantar una sorprendentemente buena interpretación de una canción popular.";
            case 6:
                return name + " de repente comienza a jugar ajedrez, realizando movimientos estratégicos con un intelecto impresionante.";
            case 7:
                return name + " inicia una rutina de baile sincronizado con otros animales presos en el zoológico.";
            case 8:
                return name + " saca una pequeña laptop y comienza a programar un emulador de juegos de zoológico en Java... pero parece tener frustración con los NullPointerExceptions.";
            case 9:
                return name + " está intentando romper los barrotes y escapar, y el personal del zoológico le está arrojando piedras para calmarlo.";
            case 10:
                return name + " comienza a dirigir una orquesta, mostrando su talento musical oculto.";
            default:
                return "...";
        }
    }
}
