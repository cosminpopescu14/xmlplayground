import lombok.ToString;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Employee") //root element of xml
@XmlType(propOrder = {"name", "age", "role", "gender"})
public class Employee {

    private int id;
    private String gender;
    private int age;
    private String name;
    private String role;
    private String password;

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient //not written in xml file
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "ID = " + id + " NAME=" + name + " AGE=" + age + " GENDER=" + gender + " ROLE=" +
                role + " PASSWORD=" + password;
    }
}
