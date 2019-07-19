import java.io.*;
import java.util.List;

class EncoderEmployee {
    void toFile(List<Handler.Employee> afterParce, List<String> listNames, String fileEncoderEmployee) {

        File myFileCreate = new File(fileEncoderEmployee);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(myFileCreate));

            DefaultHandlerEncoder defaultHandlerEncoder = new DefaultHandlerEncoder();
            HandlerEncoder handlerEncoder = new HandlerEncoder();
            defaultHandlerEncoder.startEncode(writer);

            boolean firstEmploy = true;
            int sublist = 0;
            boolean newEmploy = false;
            boolean employeeExist = false;

            for (Handler.Employee employee: afterParce){
                employeeExist = true;
                sublist = 0;
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

            if (!employeeExist){
                for (String str: listNames){
                    handlerEncoder.encodeElement(writer, new Handler.Employee(), str + " ");
                }
            }

            defaultHandlerEncoder.endEncode(writer);
            writer.close();
        }catch (NullPointerException ex){
            System.out.println("Array less than zero");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
