import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DarthVader on 17.10.2016.
 */
@Entity
@Table (name="EVENT")
public class Event implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String discriptionEvent;
    @Column
    private String date;

    public void setId(long id) {
        this.id = id;
    }

    public void setDiscriptionEvent(String discriptionEvent) {
        this.discriptionEvent = discriptionEvent;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getDiscriptionEvent() {
        return discriptionEvent;
    }

    public String getDate() {
        return date;
    }
}
