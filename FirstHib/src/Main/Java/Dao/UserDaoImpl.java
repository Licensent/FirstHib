package Dao;

import Entities.UserPO;
import Hibernate.HibernateUtil;

import javax.persistence.Query;

/**
 * Created by DarthVader on 18.10.2016.
 */
public class  UserDaoImpl extends AbstractDao<UserPO> {


    public void updateUser(String findName, String changeName, Integer age) {
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            Query query = manager.createQuery("update UserPO set person = :personParam," +
                    " age = :ageParam where person = :personCode");
            query.setParameter("personCode", findName);
            query.setParameter("personParam", changeName);
            query.setParameter("ageParam", age);
            query.executeUpdate();
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

}
