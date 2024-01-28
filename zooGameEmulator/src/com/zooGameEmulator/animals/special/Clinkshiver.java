package com.zooGameEmulator.animals.special;

public class Clinkshiver extends Beast {
    private static final String DETAILS = "No tiene una forma definida. Parece una amalgama de sombras y huesos flotantes que se retuercen y se contorsionan en un baile eterno. Las sombras toman formas cambiantes, a veces imitando rostros humanos distorsionados y otras veces adoptando siluetas monstruosas. Su cuerpo parece estar compuesto por la misma oscuridad. Fue avistado por primera vez en 1712, y su primer ejemplar capturado en 1943.";

    public Clinkshiver(String name, int age) {
        super(name, DETAILS, age);
    }

    @Override
    public String makeSounds() {
        return "No parece tener cuerdas vocales... o cuerpo, con el cual hacer ruido. Pero lo hace. Sus huesos, aunque fragmentados y desarticulados, emiten un sonido inquietante al chocar entre sí. La sombra que lo envuelve parece tener vida propia, extendiéndose y contrayéndose como si estuviera respirando.";
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
