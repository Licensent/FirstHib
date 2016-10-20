package Dao;

/**
 * Created by DarthVader on 18.10.2016.
 */
public interface Dao<T> {
    void add(T type);
    void delete(T type);
    void update(T type);
    T getObjectById (T type);
}
