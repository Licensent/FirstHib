package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by DarthVader on 17.10.2016.
 */
@Entity
@Table(name = "EVENT")
public class EventPO extends BaseEntity implements Serializable {

    @Column
    private String discriptionEvent;
    @Column
    private String date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID", nullable = false)
    private UserPO userPO;


    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    public List<TagPO> getTagPOList() {
        return tagPOList;
    }

    public void setTagPOList(List<TagPO> tagPOList) {
        this.tagPOList = tagPOList;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_x_tag",
            joinColumns = @JoinColumn(name = "Event_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Tag_ID", referencedColumnName = "ID"))
    private List<TagPO> tagPOList;

    public String getDiscriptionEvent() {
        return discriptionEvent;
    }

    public void setDiscriptionEvent(String discriptionEvent) {
        this.discriptionEvent = discriptionEvent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return "Event: "+discriptionEvent+". Date: "+date;
    }

}
