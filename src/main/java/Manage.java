import java.util.Stack;

class Manage {
    public void manageLineByLine(String currentLine, int currentNumberLine, int allNumberLine, Handler handler, Stack<String> stack) {

        if (currentNumberLine == 1 || currentNumberLine == allNumberLine) {
            if (currentNumberLine == 1) {
                handler.startDocument();
            }
            if (currentNumberLine == allNumberLine) {
                handler.endDocument();
            }
        } else {
            String[] decomposed = currentLine.split(" ");

            int i = 0;
            while (decomposed[i].equals("")) i++;
            decomposed[0] = decomposed[i];
            decomposed[1] = decomposed[i+1];

            if (decomposed[0].charAt(0) == '"') {

                int startSecondString = 0;
                int endSecondString = 0;
                if (!decomposed[1].equals("{")) {
                    startSecondString = 1;
                    endSecondString = 2;
                }

                int endSubstringName = decomposed[0].length() - 2;
                int endSubstringAttribute = decomposed[1].length() - endSecondString;

                //String s1 = decomposed[0].substring(1, endSubstringName);
                //String s2 = decomposed[1].substring(startSecondString, endSubstringAttribute);

                handler.startElement(decomposed[0].substring(1, endSubstringName), decomposed[1].substring(startSecondString, endSubstringAttribute));
                stack.push(decomposed[0]);

            }

            if (!decomposed[0].equals("{")) {
                handler.endElement(stack.pop());
                //handler.endElement(decomposed[0].substring(1, endSubstringName));
            }
        }

    }
}
