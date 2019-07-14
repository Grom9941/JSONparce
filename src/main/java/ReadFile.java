import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ReadFile {

    private static List<Integer> listSpace;

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
        listSpace = new ArrayList<>();

        assert allLines != null;
        for (String line : allLines) {
            currentNumber++;
            //give to DefaultHendler for manage sax
            int size = stack.size();
            manage.manageLineByLine(line, currentNumber, allLines.size(), handler, stack);

            if (size < stack.size()){
                listSpace.add(1);
            } else if (size > stack.size()){
                listSpace.add(-1);
            } else {
                if (listSpace.size() == 0) {
                    listSpace.add(1);
                } else {
                    listSpace.add(0);
                }
            }
        }

        return handler.returnEmployee();
        //System.out.println(handler.returnEmployee());
    }

    public List<Integer> getListSpace(){
        return listSpace;
    }
}