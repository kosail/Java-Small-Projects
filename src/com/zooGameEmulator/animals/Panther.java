package com.zooGameEmulator.animals;

public class Panther extends baseAnimal {
    
    public Panther(String name, String scientificName, String details, int age) {
        super(name, scientificName, details, age);
    }

    @Override
    public String makeSounds() {
        final int randomizer = (int) (Math.random() * 10);
        if (randomizer>7) {
            return "Meow!";
        } else {
            return "Grrrrrr!";
        }
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
