package Services;

import Entities.EventPO;
import Entities.TagPO;

import java.util.List;

/**
 * Created by DarthVader on 05.11.2016.
 */
public interface UserService {
    void connectEventTags(EventPO eventPO, List<TagPO> tagPOList);
    void createEventAndConnectTags(EventPO eventPO, List<TagPO> tagPOList);
}
