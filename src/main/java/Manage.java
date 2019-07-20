import java.util.*;

public class Manage {
     static private List<String> listNames;
     static private List<String > listAttributes;

     private static String[] splitToArray(String currentLine) {
        String[] decomposed1 = currentLine.split(" ");
        int j = 0;
        while (decomposed1[j].equals("")) j++;
        String currentLineWithoutSpace = currentLine.substring(j);

        return currentLineWithoutSpace.split(": ");
    }

    private static void pushInStack(String decomposed, Stack<String> stack) {
        if (decomposed.charAt(0) == '"') {
            stack.push(decomposed.substring(1, decomposed.length() - 1));
        } else {
            stack.push(decomposed);
        }
    }

    private static boolean checkEndElement(char decomposed) {
        boolean endElement = false;

        if (!(decomposed == '{'))
            endElement = true;

        if (decomposed == '[')
            endElement = false;

        return endElement;
    }

    private static int forSubstring(String decomposed) {
        int endSecondString = 0;

        if (decomposed.charAt(0) == '"') {
            endSecondString = 3;
        } else if (decomposed.charAt(decomposed.length() - 1) == ',') {
            endSecondString = 1;
        }

        return endSecondString;
    }

    private static void startOrEndDocument(int currentNumberLine, int allNumberLine, Handler handler) {
        if (currentNumberLine == 1) {
            handler.startDocument();
        }
        if (currentNumberLine == allNumberLine) {
            handler.endDocument();
        }
    }

    public static List<String> returnListNames() { return listNames; }

    public static List<String> returnListAttributes() { return listAttributes; }

    void manageLineByLine(String currentLine, int currentNumberLine, int allNumberLine, Handler handler, Stack<String> stack) {

        boolean endElement = false;

        if (currentNumberLine == 1 || currentNumberLine == allNumberLine) {

            startOrEndDocument(currentNumberLine, allNumberLine, handler);
            if (currentNumberLine == 1) {
                listNames = new ArrayList<>();
                listNames.add("{");
                listAttributes = new ArrayList<>();
                listAttributes.add("");
            } else {
                listNames.add("}");
                listAttributes.add("");
            }

        } else {
            String[] decomposed = splitToArray(currentLine);

            if (decomposed[0].equals("{")) {
                stack.push(decomposed[0]);
                listNames.add(decomposed[0]);
                listAttributes.add("");
            } else

            if (decomposed[0].contains("}") || decomposed[0].contains("]")) {
                endElement = true;
                listNames.add(decomposed[0]);
                listAttributes.add("");

            } else

            if (decomposed[0].charAt(0) == '"') {

                int startSecondString = 0;
                if (decomposed[1].charAt(0) == '"')
                    startSecondString = 1;

                int endSubstringName = decomposed[0].length() - 1;
                int lengthAttribute = decomposed[1].length() - forSubstring(decomposed[1]);

                handler.startElement(decomposed[0].substring(1, endSubstringName));
                handler.characters(decomposed[1].toCharArray(), startSecondString, lengthAttribute);

                listNames.add(decomposed[0] + ":");
                if (lengthAttribute != 0) {
                    listAttributes.add(decomposed[1]);
                } else {
                    listAttributes.add("");
                }

                pushInStack(decomposed[0], stack);
                endElement = checkEndElement(decomposed[1].charAt(0));
            } else {
                listNames.add(decomposed[0]);
                listAttributes.add("");
            }

            if (decomposed[0].equals("},") || endElement) {
                try {
                    handler.endElement(stack.pop());
                }catch (EmptyStackException ex) {
                    System.out.println("Not enough elements in file");
                }
            }
        }
    }
}
