package com.fileCreator;

import java.io.File; // This is to create and interact with files
import java.io.IOException; // This is for exceptions management
import java.io.FileWriter; // This works pair to pair with BufferedWriter. This one is for writting in files
import java.io.BufferedWriter; // This one is for optimization on writing to files, as FileWriter writes one char per operation, while on the opposite BufferedWriter takes everything into a buffer first, which reduces the syscalls to disk and improves a lot the tasks.

class FileCreator extends FileCreatorEngine {
    protected String packageName = null;

    public FileCreator(String fileName, String fileExtension, String filePath, int fileAmount) {
        super(fileName, fileExtension, filePath, fileAmount);
    }

    // Constructor for java files
    public FileCreator(String fileName, String fileExtension, String filePath, int fileAmount, String packageName) {
        super(fileName, fileExtension, filePath, fileAmount);
        
        if (fileExtension.equals(".psc")) {
            this.packageName = "psc";
        } else {
            this.packageName = packageName;
        }
    }

    @Override
    public void createNewFile() {
        try {
            for (int i=1;i<=fileAmount;i++) { // for struture to repeat the code for files creation as many times as the user specified 
                String completeFilePath = String.format("%s/%s%d%s",filePath,fileName, i, fileExtension);
                File batchFileCreator = new File(completeFilePath);

                if (! batchFileCreator.createNewFile()) { // If file creation fails
                    System.out.printf("The file %s%d%s already exists, thus I will not overwrite it. Skipping...\n",fileName,i,fileExtension);
                } else { // If file creation success
                    if (packageName!=null) {
                            String fileNameForClass = String.format("%s%d", fileName,i);
                            fileFiller(completeFilePath, fileNameForClass, packageName);
                        }
                    }

                    filesCounter += 1;
                }
            System.out.printf("%d %s files created.\n",filesCounter, fileExtension);
        } catch (IOException e) {
            System.out.println("An exception has ocurred. Details:\n" + e);
        }
    }

    private static void fileFiller(String completeFilePath, String fileNameForClass, String packageName) {
        try {
            String BasicSyntax = null;
            FileWriter fileSyntaxWritter = new FileWriter(completeFilePath);
            BufferedWriter bufferForWritter = new BufferedWriter(fileSyntaxWritter);

            if (packageName.equals(".java")) {
                BasicSyntax = String.format("package %s;\n\npublic class %s {\n\tpublic static void main(String[] args) {\n\t\n\t}\n}",packageName,fileNameForClass);
            } else if (packageName.equals("psc")) {
                BasicSyntax = String.format("// \nAlgoritmo %s\n\t\nFinAlgoritmo",fileNameForClass);
            }

            bufferForWritter.write(BasicSyntax);
            bufferForWritter.close();
        } catch (IOException e) {
            System.out.println("An exception has ocurred. Details:\n" + e);
        }
    }
}