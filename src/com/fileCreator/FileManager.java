package com.fileCreator;

import java.util.Scanner;

public class FileManager {

    private String fileName;
    private String fileExtension;
    private String filePath;
    private short fileAmount;
    
    public FileManager(String fileName, String fileExtension, String filePath, short fileAmount) {
        this.fileName = fileName;
        this.fileExtension = String.format(".%s",fileExtension);
        this.filePath = filePath;
        this.fileAmount = fileAmount;
    }

    public void fileNameChanger(String newFileName) { // Setter
        Scanner scannedInstructions = new Scanner(System.in);

        System.out.print("Ingresa el nombre de los archivos: ");
        fileName = scannedInstructions.nextLine();
        fileName = newFileName;

        scannedInstructions.close();
    }

    public void fileExtensionChanger(String newFileExtension) { // Setter
        Scanner scannedInstructions = new Scanner(System.in);

        System.out.print("Ingresa la extensión de los archivos sin punto: ");
        fileExtension = scannedInstructions.nextLine();
        fileExtension = String.format(".%s",newFileExtension);

        scannedInstructions.close();
    }

    public void filePathChanger(String newFilePath) { // Setter
        Scanner scannedInstructions = new Scanner(System.in);

        System.out.print("Ingresa el directorio donde los quieres: ");
        filePath = scannedInstructions.nextLine();
        filePath = newFilePath;

        scannedInstructions.close();
    }

    public void fileAmountChanger(short newFileAmount) { // Setter
        Scanner scannedInstructions = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de los archivos a crear: ");
        fileAmount = scannedInstructions.nextShort();
        this.fileAmount = newFileAmount;

        scannedInstructions.close();
    }

    public String returnStatus() { // Getter
        String currentStatus = String.format("Nombre actual: %s\nDirectorio de creación actual: %s\nNúmero de archivos a crear: %s\n",fileName,filePath,fileAmount);
        return currentStatus;
    }

    public String returnStatus(String varToCheck) { // Getter
        switch (varToCheck) {
            case "name":
                return fileName;
            case "extension":
                return fileExtension;
            case "path":
                return filePath;
            default:
                return "Valor no válido. Ingresa name, path o number según quieras tener info.";
        }
    }

    public short returnAmount() {
        return fileAmount;
    }
}