import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Encoder {
    private String createSpace(int numberSpace){
        char[] charArray = new char[numberSpace];
        Arrays.fill(charArray, ' ');
        return new String(charArray);

    }

    public void toFile(List<String> listNames, List<String> listAttributes, List<Integer> listSpace, String fileEncoder) {

        File myFileCreate = new File(fileEncoder);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(myFileCreate));

            int numberString = 0;
            int numberSpace = 0;




            for (String str: listNames){

                if (str.contains("]") || str.contains("}")) {
                    numberSpace = listSpace.get(numberString-1)-1;
                }

                String spaceString = createSpace(numberSpace);
                writer.println(spaceString + spaceString + str + " " + listAttributes.get(numberString));

                numberSpace = listSpace.get(numberString);
                numberString++;
            }
            writer.close();
        }catch (NullPointerException ex){
            System.out.println("Array less than zero");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
