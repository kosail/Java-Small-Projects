package com.InsertionSort;

public class InsertionSortPureForLoops {
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6 };

        insertionPureLoops(array);

        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void insertionPureLoops(int[] array) {

        for (int rounds = array.length; rounds>0; rounds--) {
            for (int j = 1; j<rounds; j++) {
                for (int i = j - 1; i>=0; i--) {
                    if (array[i] > array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

    }
}
