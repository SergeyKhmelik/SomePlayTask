package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.03.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Trainee {
    private int id;
    private String traineeName;
    private List<String> favouriteLanguages;
    private List<Mentor> mentors = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraineeName() {
        return traineeName;
    }
    @XmlElement
    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public List<String> getFavouriteLanguages() {
        return favouriteLanguages;
    }
    @XmlElement
    public void setFavouriteLanguages(List<String> favouriteLanguages) {
        this.favouriteLanguages = favouriteLanguages;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }
    @XmlElement
    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }
}
