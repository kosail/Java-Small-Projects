package com.zooGameEmulator.animals.special;

import com.zooGameEmulator.animals.baseAnimal;

public abstract class Beast extends baseAnimal {
    private static final String SCIENTIFICNAME = "Desconocido";

    public Beast(String name, String details, int age) {
        super(name, SCIENTIFICNAME, details, age);
    }

    @Override
    public String randomAction() {
        return randomActionGenerator((int) (Math.random() * 10));
    }

    private String randomActionGenerator(int randomAction) {
        switch (randomAction) {
            case 0:
                return "...";
            case 1:
                return super.getName() + " experimenta una metamorfosis aterradora, donde su forma se retuerce y deforma de maneras grotescas. Huesos se quiebran, carne se distorsiona y la anatomía se retuerce en una grotesca exhibición de horror corporal.";
            case 2:
                return super.getName() + " emite un canto que, en lugar de ser melodioso, parece inducir a la locura y desesperación a los conejos con los que comparte celda. Los conejos no han parado de morderse entre sí, y algunos ya no se mueven.";
            case 3:
                return super.getName() + " consume su propia carne. Se arranca pedazos y chispea el vidrio con pedazos de sí.";
            case 4:
                return "El entorno que rodea a " + super.getName() +" ondea de manera extraña. Parece que la realidad se distorsiona y se retuerce. Paisajes familiares se vuelven distorsionados, creando un mundo surrealista y pesadillesco.";
            case 5:
                return super.getName() + " demuestra poseer habilidades que corrompen todo lo que toca. Desde su simple presencia hasta sus acciones, todo a su alrededor se descompone y se retuerce, mostrando el poder oscuro y corruptor del ser. Hubiera sido difícil creerlo de no ser porque a su lado hay un empleado del zoológico al que le falta la mitad de su cuerpo, y que yace mirándote con los ojos vacíos.";
            case 6:
                return super.getName() + " fusiona lo que parecen ser dos organismos de manera aberrante. No sabes qué son, pero parecen cuerpos humanos y animales que se combinan en formas inimaginables, dando lugar a criaturas híbridas y perturbadoras que se arrastran antes de morir. No está claro que pasa por su mente, pero parece que se divierte.";
            case 7:
                return super.getName() + " no se mueve... Pero quizás es mejor así. El vidrio tiene un cartel que dice que menciona que esta... cosa... es portadora de una infección extraña que transforma a las víctimas en pesadillas vivientes. \"Aquellos afectados experimentan cambios irreversibles en su apariencia y comportamiento, de los cuales solo podrían ser solucionados acabando con la criatura infectada\".";
            case 8:
                return "El reflejo de " + super.getName() + " en espejos y superficies reflejantes cobra vida propia. Este reflejo distorsionado se inclina y llora.";
            case 9:
                return super.getName() + " está intentando romper el vidrio blindado para escapar... y se está agrietándo. El personal dice que es un vidrio blindado de 27 pulgadas y que no debería haber problemas.";
            case 10:
                return super.getName() + " emite susurros ininteligibles y perturbadores que parecen provenir de dimensiones oscuras. Hay demasiados carteles alrededor de este vidrio diciendo que no se debe quitar los auriculares protectores, pues al parecer sus susurros contienen profecías inquietantes sobre eventos por venir, y quien los escucha es atormentado hasta el suicidio.";
            default:
                return "...";
        }
    }
}
