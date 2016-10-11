import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by DarthVader on 08.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        User user = getUserByName("Drist");
        UserDao userDao = new UserDaoImpl();
        if (user != null) {
            user.setPerson("Batman");
            userDao.updateUser(user);
        } else {
            user = new User();
            user.setPerson("Drist");
            userDao.addUsers(user);
        }
        HibernateUtil.close();
    }

    private static User getUser(long id) {
        EntityManager em = HibernateUtil.getEm();
        TypedQuery<User> query = em.createQuery("from User where id = :id", User.class);
        query.setParameter("id",id);
        return executeQueryGetFirst(query);
    }


    private static User getUserByName(String name) {
        EntityManager em = HibernateUtil.getEm();
        TypedQuery<User> query = em.createQuery("from User where person = :person", User.class);
        query.setParameter("person",name);
        return executeQueryGetFirst(query);
    }


    private static User executeQueryGetFirst(TypedQuery<User> query) {
        List<User> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}
