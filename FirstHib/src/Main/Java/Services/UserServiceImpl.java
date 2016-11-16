package Services;

import Dao.EventDaoImpl;
import Entities.EventPO;
import Entities.TagPO;

import java.util.List;

/**
 * Created by DarthVader on 06.11.2016.
 */
public class UserServiceImpl implements UserService {
    private EventDaoImpl eventDao;

    public void connectEventTags(EventPO eventPO, List<TagPO> tagPOList) {
        eventPO.setTagPOList(tagPOList);
        eventDao.update(eventPO);

    }

    public void createEventAndConnectTags(EventPO eventPO, List<TagPO> tagPOList) {
        eventPO.setTagPOList(tagPOList);
        eventDao.add(eventPO);

    }

    public UserServiceImpl(EventDaoImpl eventDao) {
        this.eventDao = eventDao;
    }
}
