import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handler extends DefaultHandler {
    private List<Employee> listEmployee;

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

    private String currentElement;
    private Employee currentEmployee;

    List<Employee> returnEmployee() {
        return listEmployee;
    }

    @Override
    public void startDocument() {
        listEmployee = new ArrayList<>();
        System.out.println("Start parcing");
    }

    @Override
    public void startElement(String name, String attributes) {
        currentElement = name;

        switch (currentElement) {
            case NEWEMLOYEE_TAG: {
                currentEmployee = new Employee();
                break;
            }

            case ADDRESS_TAG: {
                currentEmployee.address = new Employee.Address();
                break;
            }

            case PHONENUMBERS_TAG: {
                currentEmployee.phone = new Employee.PhoneNumbers();
                currentEmployee.phone.phoneList = new HashMap<>();
                break;
            }
            default: {
            }
        }

    }

    @Override
    public void endElement(String name) {
        if (NEWEMLOYEE_TAG.equals(name)) {
            listEmployee.add(currentEmployee);
            currentEmployee = null;
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String text = new String(chars, start, length);
        if (chars[start] == '{' || chars[start] == '[') { //or text.contains("(") not sure yet
            return;
        }

        switch (currentElement) {
            case FIRSTNAME_TAG: {
                currentEmployee.firstName = text;
                break;
            }

            case LASTNAME_TAG: {
                currentEmployee.lastName = text;
                break;
            }

            case AGE_TAG: {
                currentEmployee.age = Integer.valueOf(text);
                break;
            }

            case STREET_ADRESS_ATTRIBUTE: {
                currentEmployee.address.streetAddress = text;
                break;
            }

            case CITY_ADRESS_ATTRIBUTE: {
                currentEmployee.address.city = text;
                break;
            }

            case STATE_ADRESS_ATTRIBUTE: {
                currentEmployee.address.state = text;
                break;
            }

            case CODE_ADRESS_ATTRIBUTE: {
                currentEmployee.address.postalCode = text;
                break;
            }

            case HOME_PHONE_ATTRIBUTE: {
                currentEmployee.phone.home = Integer.valueOf(text);
                currentEmployee.phone.phoneList.put("home", Integer.valueOf(text));
                break;
            }

            case OFFICE_PHONE_ATTRIBUTE: {
                currentEmployee.phone.office = Integer.valueOf(text);
                currentEmployee.phone.phoneList.put("office", Integer.valueOf(text));
                break;
            }

            case MOBILE_PHONE_ATTRIBUTE: {
                currentEmployee.phone.mobile = Integer.valueOf(text);
                currentEmployee.phone.phoneList.put("mobile", Integer.valueOf(text));
                break;
            }
            default: {
            }
        }
    }

}

class Employee {
    String firstName;
    String lastName;
    Integer age;
    Address address;
    PhoneNumbers phone;

    static class Address {
        String streetAddress;
        String city;
        String state;
        String postalCode;
    }

    static class PhoneNumbers {
        Map<String, Integer> phoneList;
        Integer home;
        Integer office;
        Integer mobile;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "-" + age + "\n" +
                "address " + address.streetAddress + " " + address.city + " " + address.state + "\n" +
                "code " + address.postalCode + "\n" + phone.home + " " + phone.office + " " + phone.mobile;
    }
}

