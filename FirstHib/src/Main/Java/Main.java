import Dao.EventDaoImpl;
import Dao.TagDaoImpl;
import Dao.UserDaoImpl;
import Entities.EventPO;
import Entities.TagPO;
import Entities.UserPO;
import Hibernate.HibernateUtil;

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
        eventPO1.setDiscriptionEvent("The Empire strikes back");
        eventPO2.setDiscriptionEvent("The Phantom Menace");
        eventPO3.setDiscriptionEvent("Why so series?");
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



        HibernateUtil.close();
    }
}