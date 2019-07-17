import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Handler.Employee> afterParce = ReadFile.parceDoing();
        //System.out.println(afterParce);

        List<String> listNames = Manage.returnListNames();
        List<String> listAttributes = Manage.returnListAttributes();

        Encoder encoder = new Encoder();
        encoder.toFile(listNames, listAttributes, new ReadFile().getListSpace());

        EncoderEmployee encoderEmployee = new EncoderEmployee();
        encoderEmployee.toFile(afterParce, listNames);
    }
}