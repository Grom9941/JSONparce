public class Start {
    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Input name file without \".json\": ");
        String nameFile = input.nextLine();
        input.close();
        String file = pathForFile + nameFile + ".json";*/

        String pathForFile = "src/main/resources/";
        String fileEncoder = pathForFile + "returnFile.json";
        String fileEncoderEmployee = pathForFile + "returnFileEmployee.json";

        String file = pathForFile + "myFile.json";

        Main.parceAndEncode(file, fileEncoder, fileEncoderEmployee);
    }
}