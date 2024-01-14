package com.zooGameEmulator.animals;

public class Hippo extends baseAnimal{
    private static final String SCIENTIFICNAME = "Hippopotamus amphibius";
    private static final String DETAILS = "Es un animal semiacuático que habita en ríos y lagos y donde machos adultos territoriales con grupos de cinco a treinta hembras y jóvenes controlan una zona del río. Durante el día reposan en el agua o en el fango y tanto la cópula como el parto de este animal suceden en el agua. Al anochecer se vuelven más activos y salen a comer hierbas terrestres.";

    public Hippo(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
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
