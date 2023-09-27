package com.fileCreator;

public class Main {
    public static void main(String[] args) {
        if (args.length!=4) {
            System.out.printf("Usage: java thisProgram fileName fileExtension filePath fileAmount.");
        } else {
            short fileAmount = Short.parseShort(args[3]);
            FileEngine.fileEngine(args[0], args[1], args[2], fileAmount);
        }
    }    
}
