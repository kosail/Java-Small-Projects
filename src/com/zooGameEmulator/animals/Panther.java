package com.zooGameEmulator.animals;

public class Panther extends baseAnimal {
    private static final String SCIENTIFICNAME = "Panthera";
    private static final String DETAILS = "El melanismo es muy común en los jaguares, que es común en los genes gracias a un alelo dominante, y en los leopardos, gracias a un alelo recesivo. Las típicas marcas de estos animales se mantienen, pero se ven ocultas por el color negro producido por la melanina. El albinismo y el leucismo son los efectos contrarios al producido por el melanismo.";

    public Panther(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
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
