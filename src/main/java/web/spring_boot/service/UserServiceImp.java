package web.spring_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.spring_boot.dao.UserDao;
import web.spring_boot.model.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void saveOrChangeUser(User user) {
      userDao.saveOrChangeUser(user);
   }

   @Transactional
   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }

   @Override
   public List<User> getUsers() {
      return userDao.getUsers();
   }

   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }
}
