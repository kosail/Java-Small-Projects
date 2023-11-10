package com.fileCreator;

/*
This program is to create files in bulk. This CLI version receives the instructions for the files creation through parameters over terminal.
Usage: java .com.fileCreator.Main fileName fileExtension filePath fileAmount packageName
packageName is an optional parameter and is not mandatory to use
*/

public class Main {
    public static void main(String[] args) {
        FileCreator newFile = null;
        int fileAmount;

        if (args.length==5) {
            fileAmount = Integer.parseInt(args[3]);
            newFile = new FileCreator(args[0], args[1], args[2], fileAmount, args[4]);
        } else if (args.length==4) {
            fileAmount = Integer.parseInt(args[3]);
            newFile = new FileCreator(args[0], args[1], args[2], fileAmount);
        } else {
            System.out.println("Usage: java thisProgram fileName fileExtension filePath fileAmount packageName[optional, just for .java files]");
            System.exit(1);
        }
        newFile.createNewFile();
    }    
}
