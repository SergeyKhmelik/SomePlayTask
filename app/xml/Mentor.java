package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Admin on 18.03.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Mentor {
    private int id;
    private String fullName;

    public int getId() {
        return id;
    }
    @XmlElement(name = "number")
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    @XmlElement(name = "name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
