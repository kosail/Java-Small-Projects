package com.ShellSort;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 1, 2, 3, 8, 9, 7};

        for (int gap = array.length/2; gap >= 1; gap/=2) {
            for (int j = gap; j<array.length; j++) {
                for (int i = j - gap; i>=0; i-=gap) {
                    if (array[i] > array[i + gap]) {
                        int temp = array[i + gap];
                        array[i + gap] = array[i];
                        array[i] = temp;
                    }
                }
            }
        }

        for (int num : array) {
            System.out.print(num + " ");
        }
        
    }
}