package com.ShellSort;

public class ShellSort {
    public static void main(String[] args) {
        // Creamos un arreglo de enteros desordenados
        int[] array = {5, 4, 1, 2, 3, 8, 9, 7};

        // Bucle exterior: empieza con un "gap" o intervalo que es la mitad del tamaño del arreglo
        // El "gap" reduce su valor a la mitad en cada iteración, hasta llegar a 1
        for (int gap = array.length / 2; gap >= 1; gap /= 2) {

            for (int j = gap; j < array.length; j++) { // Segundo bucle: recorre el arreglo desde el "gap" hasta el final

                for (int i = j - gap; i >= 0; i -= gap) { // Tercer bucle: se mueve hacia atrás desde la posición j hasta el inicio. Va comparando elementos que están separados por la distancia "gap"
                
                    // Compara el elemento actual con el elemento "gap" posiciones hacia adelante
                    // Si el elemento actual es mayor que el siguiente en el "gap", se intercambian
                    if (array[i] > array[i + gap]) {
                        // Guardamos temporalmente el valor del elemento en "i + gap"
                        int temp = array[i + gap];
                        // Movemos el valor de "array[i]" a la posición "i + gap"
                        array[i + gap] = array[i];
                        // Colocamos el valor temporal en la posición "i"
                        array[i] = temp;
                    }
                }

            }

        }

        // Este bucle final imprime el arreglo ya ordenado
        for (int num : array) {
            System.out.print(num + " ");  // Imprime cada número seguido de un espacio
        }
    }
}
