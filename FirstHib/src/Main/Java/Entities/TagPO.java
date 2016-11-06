package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by DarthVader on 31.10.2016.
 */
@Entity
@Table(name = "Tag")
public class TagPO extends BaseEntity implements Serializable {
    @Column(name = "tagName")
    private String tagName;
    @ManyToMany
    @JoinTable(
            name = "Event_x_Tag",
            joinColumns = @JoinColumn(name = "Event_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Tag_ID", referencedColumnName = "ID"))
    private List<EventPO> eventPOList;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<EventPO> getEventPOList() {
        return eventPOList;
    }

    public void setEventPOList(List<EventPO> eventPOList) {
        this.eventPOList = eventPOList;
    }
}
