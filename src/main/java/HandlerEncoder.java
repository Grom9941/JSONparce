import java.io.PrintWriter;
import java.util.HashMap;

public class HandlerEncoder extends DefaultHandlerEncoder {
    private static final String NEWEMLOYEE_TAG = "newEmployee";
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

    @Override
    public void encodeElement(PrintWriter writer, Employee employee, String str) {

        String strHelper = "";
        if (str.length() > 3)
            strHelper = str.substring(1,str.length() - 3);
        switch (strHelper) {
            case NEWEMLOYEE_TAG: {
                writer.println(str + "{" );
                break;
            }

            case FIRSTNAME_TAG: {
                writer.println(str + "\"" + employee.firstName + "\",");
                break;
            }

            case LASTNAME_TAG: {
                writer.println(str + "\"" + employee.lastName + "\",");
                break;
            }

            case AGE_TAG: {
                writer.println(str + employee.age + ",");
                break;
            }

            case ADDRESS_TAG: {
                writer.println(str + "{");
                break;
            }

            case STREET_ADRESS_ATTRIBUTE: {
                writer.println(str + "\"" + employee.address.streetAddress + "\",");
                break;
            }

            case CITY_ADRESS_ATTRIBUTE: {
                writer.println(str + "\"" + employee.address.city + "\",");
                break;
            }

            case STATE_ADRESS_ATTRIBUTE: {
                writer.println(str + "\"" + employee.address.state + "\",");
                break;
            }

            case CODE_ADRESS_ATTRIBUTE: {
                writer.println(str + "\"" + employee.address.postalCode + "\"");
                break;
            }

            case PHONENUMBERS_TAG: {
                writer.println(str + "[");
                break;
            }

            case HOME_PHONE_ATTRIBUTE: {
                writer.println(str + employee.phone.home);
                break;
            }

            case OFFICE_PHONE_ATTRIBUTE: {
                writer.println(str + employee.phone.office);
                break;
            }

            case MOBILE_PHONE_ATTRIBUTE: {
                writer.println(str + employee.phone.mobile);
                break;
            }

            default: {
                writer.println(str);
            }
        }

        //System.out.println(employee);
    }
}
