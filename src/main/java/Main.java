import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

public class Main {

    private static final String XML_FILE = "employees.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        // write your code here

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setAge(25);
        employee1.setName("Cosmin");
        employee1.setGender("Male");
        employee1.setRole("Developer");
        employee1.setPassword("sensitive");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setAge(28);
        employee2.setName("Charile");
        employee2.setGender("Male");
        employee2.setRole("PM");
        employee2.setPassword("sensitive1");

        EmployeeRecord employeeRecord = new EmployeeRecord();
        employeeRecord.getRecords().add(employee1);
        employeeRecord.getRecords().add(employee2);


        System.out.println("---Writing to xml file---");
        writeToXml(employeeRecord);


        System.out.println("Reading xml from url");
        System.out.println(readXml(employeeRecord).getRecords());

        readXml(employeeRecord)
                .getRecords()
                .stream()
                .filter(f -> f.getName().equals("Cosmin"))
                .forEach(f -> System.out.println(f.getRole()));


    }

    private static void writeToXml(EmployeeRecord employeeRecord) throws JAXBException  {
        var jaxbContext = JAXBContext.newInstance(EmployeeRecord.class);
        Marshaller m = jaxbContext.createMarshaller();

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //m.marshal(employee, System.out);

        m.marshal(employeeRecord, new File((XML_FILE)));
    }

    private static EmployeeRecord readXml(EmployeeRecord employee) throws JAXBException {
        var jaxbContext = JAXBContext.newInstance(EmployeeRecord.class);
        var unmarsheller = jaxbContext.createUnmarshaller();

        return (EmployeeRecord)unmarsheller.unmarshal(new File(XML_FILE));
    }

    /*
        Doesn't work. Still
     */
    private  <T> T readXmlFromUrl() throws IOException, JAXBException {

        var url = new URL("https://www.w3schools.com/xml/cd_catalog.xml");
        var http = (HttpURLConnection)url.openConnection();

        System.out.println(getClass().getGenericSuperclass());
        var jaxbContext = JAXBContext.newInstance(Object.class);
        var jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (T)jaxbUnmarshaller.unmarshal(http.getInputStream());
    }
}