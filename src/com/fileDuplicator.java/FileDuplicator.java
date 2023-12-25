import java.io.IOException;
import com.ConsoleCustomPrint.*;

/*
? Things to reimplement due possible optimizations:
?   Use class File to instanciate the FileStreamInput class, instead of using an String. in that way, it will not be necessary to create a File Object in FileWriter just to verify if the file already exists.
 */

public class FileDuplicator {
    public static void main(String[] args) {
        if (args.length==0 || args.length>2) {
            ConsoleCustomPrint.printWithColor(foregroundColors.RED, "\tThere are not enough or too much arguments.\n", false);
            ConsoleCustomPrint.printWithColor(foregroundColors.WHITE, "Usage: java fileDuplicator filePath amountOfCopy\n", false);
        } else {

            try {
                FileReader fr = new FileReader(args[0]);
                FileWriter fw = new FileWriter(fr, Integer.parseInt(args[1]));

                fw.startFileDuplication();

                if (fw.getDuplicationStatus()!=0) {
                    ConsoleCustomPrint.printWithColor(foregroundColors.GREEN, String.format("File duplicated %s times successfully!\n", fw.getDuplicationStatus()), true);
                }

            } catch (IOException e) {
                ConsoleCustomPrint.exceptionSummary(e);
            } catch (IllegalArgumentException e) {
                ConsoleCustomPrint.exceptionSummary(e);
            }

        }
    }
}