package Servlets;

import Dao.UserDaoImpl;
import Entities.UserPO;

/**
 * Created by DarthVader on 28.11.2016.
 */
public class ServiceForWeb {
    UserDaoImpl userDao = new UserDaoImpl();

    protected UserPO getUser (String name, long id) throws NullPointerException {
        UserPO userPO = userDao.getUserById(id);
        if (name.equals(userPO.getPerson())) {
            return userPO;

        }
        return null;
    }
}
