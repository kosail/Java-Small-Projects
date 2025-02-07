package com.ShellSort;

public class ShellSortAlternative {
    public static void main(String[] args) {
        // Creamos un arreglo de enteros desordenados
        int[] array = {5, 4, 1, 2, 3, 8, 9, 7};
				
        // Llamamos al método que realiza el Shell Sort, pasando el arreglo y su tamaño
		ShellSortAlt(array, array.length);
		
        // Imprimimos el arreglo ya ordenado
		for (int num : array) {
			System.out.print(num + " ");  // Imprime cada número seguido de un espacio
		}
		System.out.println();  // Salto de línea al final
    }

    private static void ShellSortAlt(int[] array, int arraySize) { // Método que implementa el algoritmo Shell Sort

        // Bucle exterior: empieza con un "gap" que es la mitad del tamaño del arreglo
        // El "gap" se reduce a la mitad en cada iteración, hasta que llega a 1
        for (int gap = arraySize / 2; gap >= 1; gap /= 2) {
            
            for (int j = gap; j < arraySize; j++) { // Bucle para recorrer el arreglo desde la posición "gap" hasta el final
                // Guardamos temporalmente el valor actual en la posición "j"
                int temp = array[j];
                // Calculamos el índice del elemento anterior que está a una distancia "gap"
                int i = j - gap;
                
                // Mientras "i" esté dentro de los límites del arreglo y el valor en "i"
                // sea mayor que el valor temporal "temp", seguimos desplazando elementos
                while (i >= 0 && array[i] > temp) {
                    // Desplazamos el valor de "array[i]" hacia adelante en "gap" posiciones
                    array[i + gap] = array[i];
                    // Actualizamos "i" para seguir comparando hacia atrás con la misma distancia "gap"
                    i -= gap;
                }
                // Una vez que encontramos la posición correcta, colocamos el valor "temp"
                // en el lugar adecuado
                array[i + gap] = temp;
            }
        }
        
    }
}
