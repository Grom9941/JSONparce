import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ReadFile {

    private static List<Integer> listSpace;

    static List<Handler.Employee> parceDoing() {

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
        listSpace = new ArrayList<>();
        boolean startArray = true;


        assert allLines != null;
        for (String line : allLines) {
            currentNumber++;
            //give to DefaultHendler for manage sax
            int size = stack.size();
            manage.manageLineByLine(line, currentNumber, allLines.size(), handler, stack);

            if (startArray) {
                startArray = false;
                listSpace.add(1);
            } else {
                if (size < stack.size()) {
                    listSpace.add(1 + listSpace.get(listSpace.size() - 1));
                } else if (size > stack.size()) {
                    listSpace.add(listSpace.get(listSpace.size() - 1) - 1);
                } else {
                    listSpace.add(listSpace.get(listSpace.size() - 1));
                }
            }
        }
        return handler.returnEmployee();
        //System.out.println(handler.returnEmployee());
    }

    List<Integer> getListSpace(){
        return listSpace;
    }
}