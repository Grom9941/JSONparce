import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class ReadFile {

    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/myFile.json/"));
            int currentNumber = 0;

            Manage manage = new Manage();
            Handler handler = new Handler();
            Stack<String> stack = new Stack<>();

            for (String line : allLines) {
                currentNumber++;
                //give to DefaultHendler for manage sax
                manage.manageLineByLine(line, currentNumber, allLines.size(), handler, stack);
                //System.out.println(line);
            }
            System.out.println(handler.returnEmployee());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}