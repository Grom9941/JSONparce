import java.util.Stack;

class Manage {
    public void manageLineByLine(String currentLine, int currentNumberLine, int allNumberLine, Handler handler, Stack<String> stack) {

        boolean endElement = false;

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
            if (i+1<decomposed.length)
                decomposed[1] = decomposed[i+1];

            if (decomposed[0].equals("{")) {
                stack.push(decomposed[0]);
            }
            if (decomposed[0].equals("}") || decomposed[0].equals("]"))
                endElement = true;

            if (decomposed[0].charAt(0) == '"') {

                int startSecondString = 0;
                int endSecondString = 0;
                if (decomposed[1].charAt(0) == '"') {
                    startSecondString = 1;
                    endSecondString = 3;
                } else {
                    if (decomposed[1].charAt(decomposed[1].length()-1) == ',')
                        endSecondString = 1;
                }
                if (decomposed[1].equals("[")) {
                    startSecondString = 0;
                    endSecondString = 0;
                }
                int endSubstringName = decomposed[0].length() - 2;
                int endSubstringAttribute = decomposed[1].length() - endSecondString;

                //String s1 = decomposed[0].substring(1, endSubstringName);
                //String s2 = decomposed[1].substring(startSecondString, endSubstringAttribute);

                handler.startElement(decomposed[0].substring(1, endSubstringName), decomposed[1].substring(startSecondString, endSubstringAttribute));
                handler.characters(decomposed[1].toCharArray(), startSecondString, endSubstringAttribute);
                stack.push(decomposed[0]);
                if (!(decomposed[1].charAt(0) == '{'))
                    endElement = true;
                if (decomposed[1].charAt(0) == '[')
                    endElement = false;
            }

            if (decomposed[0].equals("},") || endElement) {
                handler.endElement(stack.pop());
                //handler.endElement(decomposed[0].substring(1, endSubstringName));
            }
        }

    }
}
