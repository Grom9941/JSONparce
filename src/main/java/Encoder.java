import java.io.*;
import java.util.Arrays;
import java.util.List;

class Encoder {
    void toFile(List<String> listNames, List<String> listAttributes, List<Integer> listSpace) {

        File myFileCreate = new File("src/main/resources/returnFile.json");

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(myFileCreate));

            int numberString = 0;
            int numberSpace = 0;

            for (String str: listNames){

                char[] charArray = new char[numberSpace];
                Arrays.fill(charArray, ' ');
                String spaceString = new String(charArray);

                writer.println(spaceString + spaceString + str + " " + listAttributes.get(numberString));

                numberSpace += listSpace.get(numberString);
                numberString++;
            }
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
