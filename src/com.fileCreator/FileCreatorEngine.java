package com.fileCreator;

abstract class FileCreatorEngine {
    protected String fileName, fileExtension, filePath;
    protected int fileAmount, filesCounter;
    
    public FileCreatorEngine(String fileName, String fileExtension, String filePath, int fileAmount) {
        this.fileName = fileName;
        
        // In case the file extension was written without a dot, adding it.
        char dotInFileExtension = fileExtension.charAt(0);
        if(dotInFileExtension!='.') {
            this.fileExtension = String.format(".%s",fileExtension);
        } else {
            this.fileExtension = fileExtension;
        }
        
        this.filePath = filePath;
        this.fileAmount = Math.abs(fileAmount);
        filesCounter = 0; // This is to keep track of the number of files created and 
    }
    
    abstract void createNewFile();
}