import java.io.*;
import java.util.List;

public class EncoderEmployee {
        void toFile(List<Employee> afterParce, List<String> listNames) {

            File myFileCreate = new File("src/main/resources/returnFileEmployee.json");

            try {
                PrintWriter writer = new PrintWriter(new FileWriter(myFileCreate));

                DefaultHandlerEncoder defaultHandlerEncoder = new DefaultHandlerEncoder();
                HandlerEncoder handlerEncoder = new HandlerEncoder();
                defaultHandlerEncoder.startEncode(writer);

                for (Employee employee: afterParce){

                    //problem there
                    for (String str: listNames) {
                        handlerEncoder.encodeElement(writer, employee, str + " ");
                    }
                }

                defaultHandlerEncoder.endEncode(writer);
                writer.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
}
