package com.InsertionSort;

public class InsertionSort {
	public static void main() {
		// Creamos un arreglo de enteros desordenados
		int[] array = { 12, 11, 13, 5, 6 };
				
		// Llamamos al método que implementa el algoritmo de Insertion Sort, pasando el arreglo y su tamaño
		insertionSortAlgorithm(array, array.length);
		
		// Imprimimos el arreglo ya ordenado
		for (int num : array) {
			System.out.print(num + " ");  // Imprime cada número seguido de un espacio
		}
		System.out.println();  // Salto de línea al final
	}
	
	// Método que implementa el algoritmo de ordenamiento por inserción (Insertion Sort)
	private static void insertionSortAlgorithm(int[] array, int arraySize) {
		// Empezamos el bucle desde el segundo elemento (índice 1)
		// porque asumimos que el primer elemento (índice 0) ya está "ordenado"
		for (int i = 1; i < arraySize; i++) {
			// Guardamos el valor del elemento actual (el que queremos insertar en su lugar correcto)
			int key = array[i];
			
			// Inicializamos la variable j para comparar el "key" con los elementos anteriores
			// j empieza en el índice inmediatamente anterior a i
			int j = i - 1;

			// Este bucle while se ejecuta mientras j sea mayor o igual a 0
			// y el valor en array[j] sea mayor que "key".
			// Vamos moviendo los elementos mayores hacia la derecha para hacer espacio
			// para el valor "key" en la posición correcta.
			while (j >= 0 && array[j] > key) {
				// Movemos el valor de array[j] una posición a la derecha
				array[j + 1] = array[j];
				// Reducimos j para seguir comparando con el elemento anterior
				j--;
			}

			// Insertamos el valor "key" en su posición correcta (j + 1)
			array[j + 1] = key;
		}
	}
}
