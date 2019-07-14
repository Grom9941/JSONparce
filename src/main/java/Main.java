import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> afterParce = ReadFile.parceDoing();
        //System.out.println(afterParce);

        List<String> listNames = Manage.returnListNames();
        List<String> listAttributes = Manage.returnListAttributes();
        Encoder encoder = new Encoder();
        encoder.toFile(listNames, listAttributes, new ReadFile().getListSpace());
        //for (String str: arrayAfterParce1){
        //    System.out.println(str);
        //}
    }
}