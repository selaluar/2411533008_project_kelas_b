package DAO;

import model.User;

public interface UserDAO {

    void register(User user);
 
    User login(String username, String password);
}
