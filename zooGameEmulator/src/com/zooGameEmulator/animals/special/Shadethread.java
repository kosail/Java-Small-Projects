package com.zooGameEmulator.animals.special;

public class Shadethread extends Beast {
    private static final String DETAILS = "Se asemeja a una maraña de raíces retorcidas e hilos de carne podrida y de color atierrado. Su cuerpo parece fundirse con el entorno, camuflándose entre la maleza como una extensión distorsionada de la naturaleza. Se desconoce la fecha de su descubrimiento, pues se ha encontrado representaciones de esta cosa en pinturas rupestres. El primer ejemplar, sin embargo, fue capturado en el siglo XIII.";
    
    public Shadethread(String name, int age) {
        super(name, DETAILS, age);
    }

    @Override
    public String makeSounds() {
        return "Los hilos se entrelazan y se desenredan constantemente, formando patrones incomprensibles apenas perceptibles. Emiten un susurro constante que parece provenir de dimensiones más allá de la comprensión humana.";
    }

    @Override
    public String makeAction() {
        return randomAction();
    }
}
