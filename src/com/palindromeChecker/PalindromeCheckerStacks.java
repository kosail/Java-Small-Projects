package com.palindromeChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class PalindromeCheckerStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String word="", reverseWord = "";

        System.out.print("Ingresa una palabra: ");
        word = br.readLine();
        word.chars().forEach(letter -> stack.push((char) letter));

        while(!stack.isEmpty()) {
            reverseWord = String.format(reverseWord + stack.pop());
        }

        System.out.println(word.equals(reverseWord));
        br.close();
    }
}
