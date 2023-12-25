package com.zooGameEmulator.animals;

public class Hippo extends baseAnimal{
    public Hippo(String name, String scientificName, String details, int age) {
        super(name, scientificName, details, age);
    }

    @Override
    public String makeSounds() {
        final int randomizer = (int) (Math.random() * 10);
        if (randomizer>9) {
            return "Meow!";
        } else {
            return "Huuurrrrgh!";
        }
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
