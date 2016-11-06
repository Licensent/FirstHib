package Services;

import Dao.EventDaoImpl;
import Entities.EventPO;
import Entities.TagPO;

import java.util.List;

/**
 * Created by DarthVader on 06.11.2016.
 */
public class UserServiceImpl implements UserService {
    EventDaoImpl eventDao = new EventDaoImpl();
    public void connectEventTags(EventPO eventPO, List<TagPO> tagPOList) {
        EventPO event = eventDao.getObjectById(eventPO);
        event.setTagPOList(tagPOList);
        eventDao.update(event);

    }

    public void createEventAndConnectTags(EventPO eventPO, List<TagPO> tagPOList) {
        eventPO.setTagPOList(tagPOList);
        eventDao.add(eventPO);

    }
}
