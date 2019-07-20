import java.io.PrintWriter;

public class DefaultHandlerEncoder {
    public void startEncode(PrintWriter writer) {
        System.out.println("Start encoding");
        writer.print("");
    }

    public void endEncode(PrintWriter writer) {
        writer.print("");
        System.out.println("End parcing");
    }

    public void encodeElement(PrintWriter writer, Handler.Employee employee, String str) {
        System.out.println(employee.toString());
    }
}
