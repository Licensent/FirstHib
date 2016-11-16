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
    @ManyToMany(mappedBy = "tagPOList")
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
