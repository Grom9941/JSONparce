import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/myFile.json/"));
            int currentNumber = 0;
            for (String line : allLines) {
                currentNumber++;
                //give to DefaultHendler for manage sax
                Manage manage = new Manage();
                manage.manageLineByLine(line, currentNumber, allLines.size());
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}