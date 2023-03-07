package web.spring_boot.service;

import web.spring_boot.model.User;

import java.util.List;

public interface UserService {
    void saveOrChangeUser(User user);
    void deleteUser(Long id);
    List<User> getUsers();
    User getUserById(Long id);
}
