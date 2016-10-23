package Dao;

import Entities.BaseEntity;
import Hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by DarthVader on 18.10.2016.
 */
public class AbstractDao<T extends BaseEntity> implements Dao<T> {
    EntityManager manager = null;

    private Class<T> tClass;

    public AbstractDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        tClass = (Class) pt.getActualTypeArguments()[0];
    }

    public void add(T type) {
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            manager.persist(type);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }


    public void update(T type) {
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            manager.merge(type);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public void delete(T type) {
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            BaseEntity userX = manager.getReference(type.getClass(), type.getId());
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
    public T getObjectById(T type) {
        T typeClass = null;
        try {
            manager = HibernateUtil.getEm();
            manager.getTransaction().begin();
            typeClass = manager.find(tClass, type.getId());
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return typeClass;

    }

}