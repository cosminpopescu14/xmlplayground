import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class EmployeeRecord {

    public List<Employee> getRecords() {
        return records;
    }

    public void setRecords(List<Employee> employees) {
        this.records = employees;
    }

    private List<Employee> records = new ArrayList<>();




}
