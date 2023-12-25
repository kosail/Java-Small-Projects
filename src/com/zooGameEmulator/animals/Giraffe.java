package com.zooGameEmulator.animals;

public class Giraffe extends baseAnimal {
    private static final String SCIENTIFICNAME = "Giraffa";
    private static final String DETAILS = "La jirafa es el animal terrestre vivo más alto y el rumiante más grande de la Tierra. Tradicionalmente, se pensaba que las jirafas eran una sola especie, Giraffa camelopardalis, con nueve subespecies. Se le conoce como un animal silencioso, y que suele pelear hasta la muerte con otras jirafas, azotando su cuello contra el cuerpo del contrincante.";

    public Giraffe(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
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
