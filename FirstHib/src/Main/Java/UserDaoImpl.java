import javax.persistence.EntityManager;


/**
 * Created by DarthVader on 05.10.2016.
 */
public class UserDaoImpl implements UserDao {
    public void addUsers(User user) {
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public void updateUser (User user) {
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            manager.merge(user);
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
