package com.palindromeChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeCheckerArrays {

    static boolean palindromeFind(String word) {
        char[] wordArray = word.toCharArray();
        String reverseWord = "";

        for (int i=word.length()-1; i>=0; i--) {
            reverseWord = String.format(reverseWord + wordArray[i]);
        }
        return word.equals(reverseWord);
    }

    public static void main(String[] args) throws java.io.IOException {
        System.out.print("Ingresa una palabra: ");

        System.out.println(palindromeFind(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }
}
