package com.zooGameEmulator.animals;

public class Monkey extends baseAnimal {
    private static final String SCIENTIFICNAME = "Cercopithecidae";
    private static final String DETAILS = "Los cercopitécidos o monos del viejo mundo son una familia de primates de la superfamilia Cercopithecoidea incluida dentro del clado Catarrhini. Dentro de esta gran familia se clasifican 21 géneros y 139 especies vivientes e incluyen varios primates como los babuinos, cercopitecos, macacos, mandriles y colobos.";

    public Monkey(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
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
                return "Es difícil encontrar la felicidad dentro de uno mismo, pero es imposible encontrarla en cualquier otro lugar.";
            case 9:
                return "Haber muerto una vez es suficiente.";
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
