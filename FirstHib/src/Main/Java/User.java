import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DarthVader on 05.10.2016.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {
    public User() {}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name ="PERSON")
    private String person;
    @Column(name = "AGE")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String toString(){
        return "Id = " + id +"\n" +
                "Person = " + person +"\n" +
                "Age = " + age;

    }
}
