package com.zooGameEmulator.animals;

/*
 * This class should have a lot more methods, since it's an special bonus to the visitors.
 */

public class Penguins extends baseAnimal {
    public Penguins(String name, String scientificName, String details, int age) {
        super(name, scientificName, details, age);
    }

    @Override
    public String makeSounds() {
        return "Honk honk!";
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
