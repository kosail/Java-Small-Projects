package com.zooGameEmulator.animals;

public class Bear extends baseAnimal {
    public Bear(String name, String scientificName, String details, int age) {
        super(name, scientificName, details, age);
    }

    @Override
    public String makeSounds() {
        return "Gaaawrrr!";
        
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
