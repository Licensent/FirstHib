import Dao.EventDaoImpl;
import Dao.TagDaoImpl;
import Dao.UserDaoImpl;
import Entities.EventPO;
import Entities.TagPO;
import Entities.UserPO;
import Hibernate.HibernateUtil;
import Services.UserServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DarthVader on 08.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserPO userPO1 = new UserPO();
        UserPO userPO2 = new UserPO();
        userPO1.setPerson("Spider-man");
        userPO2.setPerson("Iron man");
        userDao.add(userPO1);
        userDao.add(userPO2);
//        userDao.updateUser("Spider-man", "Batman", 56);
        userPO1.setPerson("Hulk");
//        userDao.delete(userPO1);
        userDao.update(userPO1);
        EventDaoImpl eventDao = new EventDaoImpl();
        EventPO eventPO1 = new EventPO();
        EventPO eventPO2 = new EventPO();
        EventPO eventPO3 = new EventPO();
        EventPO eventPO4 = new EventPO();
        EventPO eventPO5 = new EventPO();
        eventPO1.setDiscriptionEvent("The Empire strikes back");
        eventPO2.setDiscriptionEvent("The Phantom Menace");
        eventPO3.setDiscriptionEvent("Why so series?");
        eventPO4.setDiscriptionEvent("Die another day");
        eventPO5.setDiscriptionEvent("Bruce Banner");
        eventDao.add(eventPO1);
        eventDao.add(eventPO2);
        eventDao.add(eventPO3);
        TagDaoImpl tagDao = new TagDaoImpl();
        TagPO tag1 = new TagPO();
        TagPO tag2 = new TagPO();
        tag1.setTagName("Star Wars");
        tag2.setTagName("Dark Knight");
        tagDao.add(tag1);
        tagDao.add(tag2);
        UserServiceImpl userService = new UserServiceImpl(eventDao);
        List<TagPO> tagPOList = new ArrayList<>(Arrays.asList(tagDao.getObjectById(tag1),
                tagDao.getObjectById(tag2)));
        userService.connectEventTags(eventPO3, tagPOList);
        System.out.println(eventDao.getObjectById(eventPO3).getTagPOList());
//         userService.createEventAndConnectTags(eventPO4, tagPOList);
//        System.out.println(eventDao.getObjectById(eventPO4).getTagPOList());
        List<EventPO> eventPOList = new ArrayList<>(Arrays.asList(eventPO5, eventPO5,
                eventDao.getObjectById(eventPO2)));
        userPO1.setEventPOList(eventPOList);
        userDao.update(userPO1);
        System.out.println("!" + userDao.getObjectById(userPO1).getEventPOList());


        UserPO userPOa = userDao.getObjectById(userPO1);
        userPOa.setEventPOList(eventPOList);
        userDao.update(userPOa);
        System.out.println("!!" + userDao.getObjectById(userPOa).getEventPOList());


//        eventPO3.setUserPO(userPO1);
//        eventDao.update(eventPO3);
//        System.out.println("!!!"+eventDao.getObjectById(eventPO1).getUserPO());

//        данный код работает и в бд заносит update, но возвращает почему-то null, неизвестно почему


        EventPO eventPOa = eventDao.getObjectById(eventPO3);
        eventPOa.setUserPO(userDao.getObjectById(userPO1));
        eventDao.update(eventPOa);
        System.out.println(eventDao.getObjectById(eventPOa).getUserPO());

        HibernateUtil.close();
    }
}