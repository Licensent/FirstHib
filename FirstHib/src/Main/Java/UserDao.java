/**
 * Created by DarthVader on 05.10.2016.
 */
public interface UserDao {
    void addUsers(User user);
    void updateUser(String foundName, String changeName, Integer age);
    }
