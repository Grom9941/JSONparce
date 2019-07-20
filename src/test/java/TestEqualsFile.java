import java.io.*;

public class TestEqualsFile {

    public static void main(String[] args) throws IOException {

        new TestEqualsFile("src/main/resources/myFile.json","src/main/resources/returnFile.json");
        new TestEqualsFile("src/main/resources/myFile.json","src/main/resources/returnFileEmployee.json");

    }

    private TestEqualsFile(String pathOne, String pathTwo) throws IOException {
        File one = new File(pathOne);
        File two = new File(pathTwo);
            if(!one.exists()||!two.exists())
            {
                System.out.println("No File exists");
            } else {
                BufferedReader first = new BufferedReader(new InputStreamReader(new FileInputStream(one)));
                BufferedReader second = new BufferedReader(new InputStreamReader(new FileInputStream(two)));

                int countEqualsStr = 0;
                int countString = 0;
                String f = first.readLine();
                String s = second.readLine();

                while (f!= null && s!= null){

                    if(f.trim().equals(s.trim()))
                        countEqualsStr++;

                    f = first.readLine();
                    s = second.readLine();
                    countString++;
                }

                String nextStr = second.readLine();
                if (nextStr != null && !nextStr.equals("")){
                    countString++;
                }

                if (countEqualsStr == countString){
                    System.out.println("File equals");
                }
            }
        }
}
