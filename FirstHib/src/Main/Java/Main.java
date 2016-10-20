import Hibernate.HibernateUtil;
import Dao.UserDaoImpl;
import Entities.UserPO;

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
//        userPO1.setPerson("Hulk");
        userDao.delete(userPO1);
//        userDao.updateUser(userPO1);


        HibernateUtil.close();
    }
}