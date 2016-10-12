import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by DarthVader on 05.10.2016.
 */
public class UserDaoImpl implements UserDao {
    EntityManager manager = null;

    public void addUsers(User user) {
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

    public void updateUser(String foundName, String changeName, Integer age) {
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            Query query = manager.createQuery("update User set person = :personParam," +
                    " age = :ageParam where person = :personCode");
            query.setParameter("personCode", foundName);
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

    public void updateUser(User user) {
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

    public void deleteUser(User user) {
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            User userX = manager.getReference(User.class, user.getId());
            manager.remove(userX);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }

    }


    public List<User> getAll() {
        EntityManager em = HibernateUtil.getEm();
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

}
