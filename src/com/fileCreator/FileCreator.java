package com.fileCreator;

import java.io.File; // This is to create and interact with files
import java.io.IOException; // This is for exceptions management
import java.io.FileWriter; // This works pair to pair with BufferedWriter. This one is for writing in files
import java.io.BufferedWriter; // This one is for optimization on writing to files, as FileWriter writes one char per operation, while on the opposite BufferedWriter takes everything into a buffer first, which reduces the sys-calls to disk and improves a lot the tasks.

class FileCreator extends FileCreatorEngine {
    protected String packageName = null;

    public FileCreator(String fileName, String fileExtension, String filePath, int fileAmount) {
        super(fileName, fileExtension, filePath, fileAmount);

        // if no package name provided, create empty files. However, if it's a PSeInt type file, manually assign the package name to psc
        if (fileExtension.equals(".psc")) {
            this.packageName = "psc";
        }
    }

    // Constructor for java files
    public FileCreator(String fileName, String fileExtension, String filePath, int fileAmount, String packageName) {
        super(fileName, fileExtension, filePath, fileAmount);
        this.packageName = packageName;
    }

    @Override
    public void createNewFile() {
        try {
            for (int i=1;i<=fileAmount;i++) { // for structure to repeat the code for files creation as many times as the user specified
                String completeFilePath = String.format("%s/%s%d%s",filePath,fileName, i, fileExtension);
                File batchFileCreator = new File(completeFilePath);

                if (! batchFileCreator.createNewFile()) { // If file creation fails
                    System.out.printf("The file %s%d%s already exists, thus I will not overwrite it. Skipping...\n",fileName,i,fileExtension);
                } else { // If file creation success
                    if (packageName!=null) {
                            String fileNameForClass = String.format("%s%d", fileName,i);
                            fileFiller(completeFilePath, fileNameForClass, fileExtension, packageName);
                            filesCounter += 1; // To keep tracking of only and every file created
                        }
                    }

                }
            System.out.printf("%d %s files created.\n",filesCounter, fileExtension);
        } catch (IOException e) {
            System.out.println("An exception has occurred. Details:\n" + e);
        }
    }

    private static void fileFiller(String completeFilePath, String fileNameForClass, String fileExtension, String packageName) {
        try {
            String BasicSyntax;
            FileWriter fileSyntaxWriter = new FileWriter(completeFilePath);
            BufferedWriter bufferForWriter = new BufferedWriter(fileSyntaxWriter);

            // Write psc file syntax if packageName is == to "psc", as mentioned in line 14
            if (packageName.equals("psc")) { 
                BasicSyntax = String.format("// \nAlgoritmo %s\n\t\nFinAlgoritmo",fileNameForClass);
            // If it's a java file but there was no package name provided
            } else if (fileExtension.equals(".java") && packageName==null) {
                BasicSyntax = String.format("public class %s {\n\tpublic static void main(String[] args) {\n\t\n\t}\n}",fileNameForClass);
            // Later on when escalating code to make C or SQL files, make this "else" into a smarter structure. As for now, it fulfills.
            } else {
                BasicSyntax = String.format("package %s;\n\npublic class %s {\n\tpublic static void main(String[] args) {\n\t\n\t}\n}",packageName,fileNameForClass);
            }

            bufferForWriter.write(BasicSyntax);
            bufferForWriter.close();
        } catch (IOException e) {
            System.out.println("An exception has occurred. Details:\n" + e);
        }
    }
}