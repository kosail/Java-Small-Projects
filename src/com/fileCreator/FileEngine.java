package com.fileCreator;

import java.io.File; // This is to create and interact with files
import java.io.IOException; // This is for exceptions management
import java.io.FileWriter; // This works pair to pair with BufferedWriter. This one is for writting in files
import java.io.BufferedWriter; // This one is for optimization on writing to files, as FileWriter writes one char per operation, while on the opposite BufferedWriter takes everything into a buffer first, which reduces the syscalls to disk and improves a lot the tasks.

public class FileEngine {
    
    public static void fileEngine(String fileName, String fileExtension, String filePath, short fileAmount) {
        short filesCounter = 0;

        try {
            for (int i=1;i<=fileAmount;i++) {
                String completeFilePath = String.format("%s/%s%d%s",filePath,fileName, i, fileExtension);
                File batchFileCreator = new File(completeFilePath);

                if (batchFileCreator.createNewFile()) {
                    if (fileExtension.equals(".java")) {
                        String fileNameForClass = String.format("%s%d", fileName,i);
                       javaFile(completeFilePath, fileNameForClass);
                    }
                    filesCounter += 1;

                } else {
                    System.out.printf("The file %s%d%s already exists, thus I will not overwrite it. Skipping...\n",fileName,i,fileExtension);
                }
            }
            System.out.printf("%d %s files created.\n",filesCounter, fileExtension);

        } catch (IOException e) {
            System.out.println("An exception has ocurred. Details:\n" + e);
        }

    }

    private static void javaFile(String completeFilePath, String fileNameForClass) {
        try {
            FileWriter javaWritter = new FileWriter(completeFilePath);
            BufferedWriter bufferForJavaWritter = new BufferedWriter(javaWritter);
            String javaBasicSyntax = String.format("public class %s {\n\tpublic static void main(String[] args) {\n\t\n\t}\n}",fileNameForClass);

            bufferForJavaWritter.write(javaBasicSyntax);
            bufferForJavaWritter.close();
        } catch (IOException e) {
            System.out.println("An exception has ocurred. Details:\n" + e);
        }
    }

}
