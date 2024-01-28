package com.zooGameEmulator.animals.special;

public class Saya extends Beast {
    private static final String DETAILS = "Tiene una apariencia inusual y macabra. Su figura es pequeña y delgada, pero su piel tiene una textura anormal y está cubierta de algo similar a la carne pero descompuesta. Su aspecto es grotesco y desfigurado, reflejando la naturaleza retorcida de su existencia. El personal tiene mascaras de gas, pues se dice que esta cosa emana un olor nauseabundo y repulsivo que describen como algo que no debería existir en este mundo. Fue avistado por primera vez en 2003, y su primer ejemplar capturado en el mismo año.";

    public Saya(String name, int age) {
        super(name, DETAILS, age);
    }

    @Override
    public String makeSounds() {
        return super.getName() + " emitió un sonido que rompió la quietud de la habitación. Era como un susurro enfermizo, un murmullo que resonaba en lo más profundo de la inmundicia. Un eco gutural y discordante, como si las sombras mismas estuvieran retorciéndose en un lamento inhumano. Era un sonido que desafiaba la lógica y estremecía el alma, dejando tras de sí una sensación de malestar que perduraba en el aire.";
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
