package com.zooGameEmulator.animals;

/*
 * This class should have a lot more methods, since it's an special bonus to the visitors.
 */

public class Penguins extends baseAnimal {
    private static final String SCIENTIFICNAME = "Spheniscidae";
    private static final String DETAILS = "Son aves marinas, no voladoras, que se distribuían casi exclusivamente en el hemisferio sur, exceptuando el pingüino de las islas Galápagos (Spheniscus mendiculus). El nombre del orden proviene del vocablo spheniscus, el cual proviene del griego σφήν (sphen, 'cuña'), y el sufijo diminutivo -iscus, literalmente \"cuñita\", haciendo referencia a su forma hidrodinámica al nadar. Hay al menos 18 especies conocidas.";

    public Penguins(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
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
