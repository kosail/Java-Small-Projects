package com.InsertionSort;

public class InsertionSort {
	public static void main() {
		int[] array = { 12, 11, 13, 5, 6 };
				
		insertionSortAlgorithm(array, array.length);
		
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}
	
	private static void insertionSortAlgorithm(int[] array, int arraySize) {
		for (int i=1; i<arraySize; i++) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = key;
		}
	}
}
