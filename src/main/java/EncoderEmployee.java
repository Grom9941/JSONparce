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

                boolean firstEmploy = true;
                int sublist = 0;
                boolean newEmploy = false;
                for (Employee employee: afterParce){
                    //problem there
                    nameLoop:
                    {
                        for (String str : listNames) {
                            sublist++;

                            if (str.equals(HandlerEncoder.NEWEMLOYEE_TAG_MARK)) {
                                if (firstEmploy){
                                    firstEmploy = false;
                                } else {
                                    listNames = listNames.subList(sublist, listNames.size());
                                    newEmploy = true;
                                }
                            }

                            handlerEncoder.encodeElement(writer, employee, str + " ");

                            if (newEmploy) {
                                newEmploy = false;
                                break nameLoop;
                            }
                        }
                    }
                }

                defaultHandlerEncoder.endEncode(writer);
                writer.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
}
