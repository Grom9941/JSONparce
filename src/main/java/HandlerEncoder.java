import java.io.PrintWriter;
import java.util.Arrays;

public class HandlerEncoder extends DefaultHandlerEncoder {
    private static final String NEWEMLOYEE_TAG = "newEmployee";
    static final String NEWEMLOYEE_TAG_MARK = "\"newEmployee\":";
    private static final String FIRSTNAME_TAG = "firstName";
    private static final String LASTNAME_TAG = "lastName";
    private static final String AGE_TAG = "age";
    private static final String ADDRESS_TAG = "address";
    private static final String PHONENUMBERS_TAG = "phoneNumbers";

    private static final String STREET_ADRESS_ATTRIBUTE = "streetAddress";
    private static final String CITY_ADRESS_ATTRIBUTE = "city";
    private static final String STATE_ADRESS_ATTRIBUTE = "state";
    private static final String CODE_ADRESS_ATTRIBUTE = "postalCode";

    private static final String HOME_PHONE_ATTRIBUTE = "number:home";
    private static final String OFFICE_PHONE_ATTRIBUTE = "number:office";
    private static final String MOBILE_PHONE_ATTRIBUTE = "number:mobile";

    private int space = 2;
    private int increaseCount = 2;
    private boolean endEmployee = false;

    private void increaseSpace(){
        space += increaseCount;
    }

    private void decreaseSpace(){
        space -= increaseCount;
    }

    private void writeSpace(PrintWriter writer){
        char[] charArray = new char[space];
        Arrays.fill(charArray, ' ');
        writer.print(new String(charArray));
    }

    @Override
    public void encodeElement(PrintWriter writer, Handler.Employee employee, String str) {

        String strHelper = "";
        if (str.length() > 3)
            strHelper = str.substring(1,str.length() - 3);

        switch (strHelper) {
            case NEWEMLOYEE_TAG: {
                writeSpace(writer);
                endEmployee = false;
                increaseSpace();

                writer.println(str + "{" );
                break;
            }

            case FIRSTNAME_TAG: {
                writeSpace(writer);

                writer.println(str + "\"" + employee.firstName + "\",");
                break;
            }

            case LASTNAME_TAG: {
                writeSpace(writer);

                writer.println(str + "\"" + employee.lastName + "\",");
                break;
            }

            case AGE_TAG: {
                writeSpace(writer);

                writer.println(str + employee.age + ",");
                break;
            }

            case ADDRESS_TAG: {
                writeSpace(writer);
                increaseSpace();

                writer.println(str + "{");
                break;
            }

            case STREET_ADRESS_ATTRIBUTE: {
                writeSpace(writer);

                writer.println(str + "\"" + employee.address.streetAddress + "\",");
                break;
            }

            case CITY_ADRESS_ATTRIBUTE: {
                writeSpace(writer);

                writer.println(str + "\"" + employee.address.city + "\",");
                break;
            }

            case STATE_ADRESS_ATTRIBUTE: {
                writeSpace(writer);

                writer.println(str + "\"" + employee.address.state + "\",");
                break;
            }

            case CODE_ADRESS_ATTRIBUTE: {
                writeSpace(writer);
                decreaseSpace();

                writer.println(str + "\"" + employee.address.postalCode + "\"");
                break;
            }

            case PHONENUMBERS_TAG: {
                writeSpace(writer);
                increaseSpace();

                writer.println(str + "[");
                break;
            }

            case HOME_PHONE_ATTRIBUTE: {
                increaseSpace();
                writeSpace(writer);
                decreaseSpace();

                writer.println(str + employee.phone.home);
                break;
            }

            case OFFICE_PHONE_ATTRIBUTE: {
                increaseSpace();
                writeSpace(writer);
                decreaseSpace();

                writer.println(str + employee.phone.office);
                break;
            }

            case MOBILE_PHONE_ATTRIBUTE: {
                increaseSpace();
                writeSpace(writer);

                writer.println(str + employee.phone.mobile);

                endEmployee = true;
                break;
            }

            default: {
                if (endEmployee)
                    decreaseSpace();

                if (space>0)
                    writeSpace(writer);
                writer.println(str);
            }
        }

        //System.out.println(employee);
    }
}
