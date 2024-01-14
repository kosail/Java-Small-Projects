package com.fileDuplicator.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.consoleCustomPrint.ConsoleCustomPrint;
import com.consoleCustomPrint.ForegroundColors;

public class FileWriter {
    private String fileName, fileExtension;
    private final byte[] fileContent;
    private final int copyAmount;
    private int counter = 0;
    
    public FileWriter(FileReader fileToDuplicate, int copyAmount) throws IOException, IllegalArgumentException {
        this.fileName = fileToDuplicate.getFileName();
        this.fileExtension = fileName.substring(fileName.lastIndexOf("."));
        this.fileName = fileName.substring(0, fileName.lastIndexOf("."));

        this.fileContent = fileToDuplicate.getFileContent();
        this.copyAmount = Math.abs(copyAmount);
        
        if (this.copyAmount == 0) {
            throw new IllegalArgumentException("The amount of copies cannot be zero!");
        }
    }
    
    void startFileDuplication() throws IOException {
        for (int i=1;i<=copyAmount;i++) {
            String newFilenames = String.format("%s-copy-%d%s", fileName, i, fileExtension);
            File fileAlreadyExists = new File(newFilenames);
            if (fileAlreadyExists.exists()) {
                ConsoleCustomPrint.printWithColor(ForegroundColors.YELLOW, String.format("%s already exists, skipping...\n", newFilenames), false);
            } else {
                try (FileOutputStream fos = new FileOutputStream(newFilenames)) {
                    fos.write(fileContent);
                    counter++;
                }
            }
        }
    }

    int getDuplicationStatus() {
        return counter;
    }
}
