import java.io.PrintWriter;

public class DefaultHandlerEncoder {

    public void startEncode(PrintWriter writer) {
        System.out.println("Start encoding");
    }

    void endEncode(PrintWriter writer) {
        System.out.println("End parcing");
    }

    public void encodeElement(PrintWriter writer,Employee employee, String str) {
        //System.out.println(employee.toString());
    }
}
