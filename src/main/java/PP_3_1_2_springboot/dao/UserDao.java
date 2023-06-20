package PP_3_1_2_springboot.dao;

import PP_3_1_2_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void add (User user);
    User getUser(int id);
    void update (int id,User user);
    void delete (int id);
}
