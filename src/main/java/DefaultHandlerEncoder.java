import java.io.PrintWriter;

public class DefaultHandlerEncoder {

    void startEncode(PrintWriter writer) {
        System.out.println("Start encoding");
        writer.print("");
    }

    void endEncode(PrintWriter writer) {
        writer.print("");
        System.out.println("End parcing");
    }

    public void encodeElement(PrintWriter writer, Handler.Employee employee, String str) {
        System.out.println(employee.toString());
    }
}
