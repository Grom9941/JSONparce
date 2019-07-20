import java.util.List;

public class Main {
    static void parceAndEncode(String strFile, String fileEncoder, String fileEncoderEmployee){
        List<Handler.Employee> afterParce = ReadFile.parceDoing(strFile);
        //System.out.println(afterParce);

        List<String> listNames = Manage.returnListNames();
        List<String> listAttributes = Manage.returnListAttributes();

        Encoder encoder = new Encoder();
        encoder.toFile(listNames, listAttributes, new ReadFile().getListSpace(), fileEncoder);

        EncoderEmployee encoderEmployee = new EncoderEmployee();
        encoderEmployee.toFile(afterParce, listNames, fileEncoderEmployee);

        /*try {
            Files.deleteIfExists(Paths.get(fileEncoder));
            Files.deleteIfExists(Paths.get(fileEncoderEmployee));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}