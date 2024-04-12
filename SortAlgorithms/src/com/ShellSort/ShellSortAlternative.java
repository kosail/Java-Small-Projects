package com.ShellSort;

public class ShellSortAlternative {
    public static void main(String[] args) {
        int[] array = {5, 4, 1, 2, 3, 8, 9, 7};
				
		ShellSortAlt(array, array.length);
		
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
    }

    private static void ShellSortAlt(int[] array, int arraySize) {
        for (int gap = arraySize / 2; gap >= 1; gap /= 2) {
            for (int j = gap; j < arraySize; j++) {
                int temp = array[j];
                int i = j - gap;
                
                while (i >= 0 && array[i] > temp) {
                    array[i + gap] = array[i];
                    i -= gap;
                }
                array[i + gap] = temp;
            }
        }
    }
}
