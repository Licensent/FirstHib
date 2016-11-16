package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by DarthVader on 05.10.2016.
 */
@Entity
@Table(name = "USER")
public class UserPO extends BaseEntity implements Serializable {
    @Column(name = "PERSON")
    private String person;
    @Column(name = "AGE")
    private int age;
    @OneToMany(mappedBy = "userPO")
    private List<EventPO> eventPOList;

    public UserPO() {
    }

    public List<EventPO> getEventPOList() {
        return eventPOList;
    }

    public void setEventPOList(List<EventPO> eventPOList) {
        this.eventPOList = eventPOList;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Id = " + getId() + "\n" +
                "Person = " + person + "\n" +
                "Age = " + age;

    }
}
