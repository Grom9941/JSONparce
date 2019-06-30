import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/myFile.json/"));
            for (String line : allLines) {
                //give to DefaultHendler for manage sax
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}