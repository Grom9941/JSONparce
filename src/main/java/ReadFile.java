import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

class ReadFile {

    static List<Employee> parceDoing() {

        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(Paths.get("src/main/resources/myFile.json/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int currentNumber = 0;

        Manage manage = new Manage();
        Handler handler = new Handler();
        Stack<String> stack = new Stack<>();

        assert allLines != null;
        for (String line : allLines) {
            currentNumber++;
            //give to DefaultHendler for manage sax
            manage.manageLineByLine(line, currentNumber, allLines.size(), handler, stack);
        }

        return handler.returnEmployee();
        //System.out.println(handler.returnEmployee());
    }
}