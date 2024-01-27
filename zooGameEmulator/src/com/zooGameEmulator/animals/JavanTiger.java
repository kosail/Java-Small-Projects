package com.zooGameEmulator.animals;

public class JavanTiger extends baseAnimal {
    private static final String SCIENTIFICNAME = "Panthera tigris sondaica";
    private static final String DETAILS = "Es una subespecie de tigre, hoy extinta, que se encontraba originalmente en la isla Indonesa de Java. De aspecto bastante similar al tigre de Sumatra, se diferenciaba de este por su pelaje más oscuro y rayas negras más finas, abundantes y apretadas. El tigre de java dejaba los huesos y comía la carne. Algunos ejemplares de esta subespecie llegaban a tener más de 100 rayas, muchas más que cualquier otra subespecie de tigre. Así mismo, el pelo de las mejillas de los tigres de Java era más largo que el de los demás tigres, y las rayas de los flancos y la espalda se distribuían por parejas.";

    public JavanTiger(String name, int age) {
        super(name, SCIENTIFICNAME, DETAILS, age);
    }

    @Override
    public String makeSounds() {
        final int randomizer = (int) (Math.random() * 10);

        switch(randomizer) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return "Grrrrr!";
            case 8:
            case 9:
                return "You humans killed me and chased my ancestors until the extintion. Apa sampeyan kabeh bakal mbayar iki... lan iki ora guyon.";
            default:
                return "Meow";
        }
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}