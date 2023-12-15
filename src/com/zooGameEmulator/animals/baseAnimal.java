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

    void readInformationCard() {
        ConsoleCustomPrint.printWithColor(backgroundColors.YELLOW, name.toUpperCase(), true);
        
        ConsoleCustomPrint.printWithColor(foregroundColors.BLUE_DARK, "Nombre científico: ", false);
        System.out.println(scientificName);
        
        ConsoleCustomPrint.printWithColor(foregroundColors.BLUE_DARK, "Edad de este ejemplar: ", false);
        System.out.println(age);
        
        ConsoleCustomPrint.printWithColor(foregroundColors.BLUE_LIGHT, "Información sobre este animal:", false);
        System.out.println(details);
    }

    abstract void makeSounds();

    void randomAction() {
        final int randomAction = (int) (Math.random() * 10);
        randomActionGenerator(randomAction);
    }
    // ! Falta definir las acciones que van a tener los animales, y que el método RandomActionGenerator devuelva un String. Ya luego voy a decidir si el método randomAction va a imprimir las acciones por sí sola, o si va a hacer un return de String y que cada animal lo maneje como quiera.
    
    private String randomActionGenerator(int randomAction) {
        switch (randomAction) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            default:
        }
        return null;
    }
}
