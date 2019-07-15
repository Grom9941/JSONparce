import java.io.PrintWriter;

public class DefaultHandlerEncoder {

    public void startEncode(PrintWriter writer) {
        System.out.println("Start encoding");
        writer.println("{");
    }

    void endEncode(PrintWriter writer) {
        System.out.println("End parcing");
        writer.println("}");
    }

    public void encodeElement(String name) {
        System.out.println("Start element - " + name + "\n");
    }
}
