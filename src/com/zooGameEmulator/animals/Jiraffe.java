package com.zooGameEmulator.animals;

public class Jiraffe extends baseAnimal {
    public Jiraffe(String name, String scientificName, String details, int age) {
        super(name, scientificName, details, age);
    }

    @Override
    public String makeSounds() {
        return "Groooaan!";
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
