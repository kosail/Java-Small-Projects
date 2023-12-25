package com.zooGameEmulator.animals;

public class Monkey extends baseAnimal {
    public Monkey(String name, String scientificName, String details, int age) {
        super(name, scientificName, details, age);
    }

    @Override
    public String makeSounds() {
        final int randomizer = (int) (Math.random() * 10);

        switch (randomizer) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return "Ooh ooh, aah aah!";
            case 8:
                return "It is difficult to find happiness within oneself, but it is impossible to find it anywhere else.";
            case 9:
                return "To have died once is enough.";
            case 10:
                return "Memento Mori...";
            default:
                return "...";
        }
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
