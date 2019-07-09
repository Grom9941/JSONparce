public abstract class DefaultHandler {

    public void startDocument() {
        System.out.println("Start parcing");
    }

    void endDocument() {
        System.out.println("End parcing");
    }

    public void startElement(String name, String attributes) {
        System.out.println("Start element - " + name + "\n" + "Attribute = " + attributes);
    }

    public void endElement(String name) {
        System.out.println("End element - " + name);
    }

    public void characters(char[] chars, int start, int length) {
        String text = new String(chars, start, length);
        System.out.println("Content = " + text);
    }

}
