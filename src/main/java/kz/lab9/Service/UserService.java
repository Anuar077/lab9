package kz.lab9.Service;

import kz.lab9.User.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
}
