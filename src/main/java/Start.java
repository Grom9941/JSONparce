public class Start {
    public static void main(String[] args) {
        String pathForFile = "src/main/resources/";
        String fileEncoder = pathForFile + "returnFile.json";
        String fileEncoderEmployee = pathForFile + "returnFileEmployee.json";

        String file = pathForFile + "myFile.json";

        Main.parceAndEncode(file, fileEncoder, fileEncoderEmployee);


    }
}