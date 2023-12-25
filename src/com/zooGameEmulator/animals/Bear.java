package com.zooGameEmulator.animals;

public class Bear extends baseAnimal {
    private static final String SCIENTIFICNAME = "Ursidae";
    private static final String DETAILS = "Son animales de gran tamaño, generalmente omnívoros, ya que, a pesar de su temible dentadura, comen frutos, raíces e insectos, además de carne. Con sus pesados cuerpos y sus poderosas mandíbulas, los osos se encuentran entre los mayores carnívoros que viven en la Tierra.";

    public Bear(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
    }

    @Override
    public String makeSounds() {
        return "Gaaawrrr!";
        
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
