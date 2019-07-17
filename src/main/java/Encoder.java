import java.io.*;
import java.util.Arrays;
import java.util.List;

class Encoder {
    private String createSpace(int numberSpace){
        char[] charArray = new char[numberSpace];
        Arrays.fill(charArray, ' ');
        return new String(charArray);

    }

    void toFile(List<String> listNames, List<String> listAttributes, List<Integer> listSpace) {

        File myFileCreate = new File("src/main/resources/returnFile.json");

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
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
