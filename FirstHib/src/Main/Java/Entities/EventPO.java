package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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

    public List<TagPO> getTagPOList() {
        return tagPOList;
    }

    public void setTagPOList(List<TagPO> tagPOList) {
        this.tagPOList = tagPOList;
    }

    @ManyToMany(mappedBy = "eventPOList")
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

}
