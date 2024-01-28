package com.zooGameEmulator.animals.special;

public class MeltingAnimal extends Beast {
    private static final String DETAILS = "Su cuerpo parece una amalgama de colores destrozados, como si su piel estuviera perpetuamente derritiéndose en un lienzo surrealista. Cada parte de su anatomía se desliza y mezcla con la siguiente, creando una visión grotesca de la desintegración. No solo transmite una sensación viscosa y pegajosa, sino que también lleva consigo la extraña experiencia de sentirse desvanecerse en la realidad. Fue avistado por primera vez en 1505, y su primer ejemplar capturado en 1507.";

    public MeltingAnimal(String name, int age) {
        super(name, DETAILS, age);
    }

    @Override
    public String makeSounds() {
        return "Gluftworp... Gluftworp";
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
