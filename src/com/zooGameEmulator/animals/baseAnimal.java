package com.zooGameEmulator.animals;

import com.ConsoleCustomPrint.*;

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
        ConsoleCustomPrint.printWithColor(backgroundColors.YELLOW, name.toUpperCase() + "\n", true);
        
        ConsoleCustomPrint.printWithColor(foregroundColors.RED, "Nombre científico: ", false);
        System.out.println(scientificName);
        
        ConsoleCustomPrint.printWithColor(foregroundColors.GREEN, "Edad de este ejemplar: ", false);
        System.out.println(age);
        
        ConsoleCustomPrint.printWithColor(foregroundColors.BLUE_LIGHT, "Información sobre este animal:", false);
        System.out.println(details);
    }

    protected abstract String makeSounds();
    protected abstract String makeAction();

    public String randomAction() {
        final int randomAction = (int) (Math.random() * 10);
        return randomActionGenerator(randomAction);
    }
    
    private String randomActionGenerator(int randomAction) {
        switch (randomAction) {
            case 0:
                return "...";
            case 1:
                return "hace una voltereta y le guiña un ojo a los visitantes.";
            case 2:
                return "comienza a bailar breakdance inesperadamente, impresionando a todos alrededor.";
            case 3:
                return "finge ser un superhéroe, secuestra a un niño de entre la gente y lo salva él mismo.";
            case 4:
                return "comienza a hacer standup... está haciendo chiste sobre el personal de hoteles.";
            case 5:
                return "agarra un micrófono y comienza a cantar una sorprendentemente buena interpretación de una canción popular.";
            case 6:
                return "de repente comienza a jugar ajedrez, realizando movimientos estratégicos con un intelecto impresionante.";
            case 7:
                return "inicia una rutina de baile sincronizado con otros animales presos en el zoológico.";
            case 8:
                return "saca una pequeña laptop y comienza a programar un emulador de juegos de zoológico en Java... pero parece tener frustración con los NullPointerExceptions.";
            case 9:
                return "está intentando romper los barrotes y escapar, y el personal del zoológico le está arrojando piedras para calmarlo.";
            case 10:
                return "comienza a dirigir una orquesta, mostrando su talento musical oculto.";
            default:
                return "...";
        }
    }
}
