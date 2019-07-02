class Manage {
    public void manageLineByLine(String currentLine, int currentNumberLine, int allNumberLine) {
        Handler handler = new Handler();
        if (currentNumberLine == 1 || currentNumberLine == allNumberLine) {
            if (currentNumberLine == 1) {
                handler.startDocument();
            }
            if (currentNumberLine == allNumberLine) {
                handler.endDocument();
            }
        } else {
            String[] decomposed = currentLine.split(" ");
            if (decomposed[0].charAt(0) == '"') {
                int endSubstringName = decomposed[0].length() - 1;
                int endSubstringAttribute = decomposed[1].length() - 1;

                handler.startElement(decomposed[0].substring(1, endSubstringName), decomposed[1].substring(1, endSubstringAttribute));

                if (!decomposed[1].substring(1, endSubstringAttribute).equals("{")) {
                    handler.endElement(decomposed[0].substring(1, endSubstringName));
                }
            }
        }

    }
}
