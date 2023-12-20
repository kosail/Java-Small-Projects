import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
    private final String filePath;
    byte[] fileContent;
    FileInputStream fis;

    public FileReader(String filePath) throws IOException {
        this.filePath = filePath;
        fis = new FileInputStream(this.filePath);
        fileContent = new byte[fis.available()];
    }
    
    public byte[] getFileContent() throws IOException{
        fis.read(fileContent);
        return fileContent;
    }

    public String getFileName() {
        return filePath;
    }
}
