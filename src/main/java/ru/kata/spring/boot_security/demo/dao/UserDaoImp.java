package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void saveOrChangeUser(User user) {
//      user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
      if (user.getId() != null) {
         entityManager.merge(user);
      } else {
         entityManager.persist(user);
      }
   }

   @Override
   public void deleteUser(Long id) {
      entityManager.remove(getUserById(id));
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUsers() {
      return entityManager.createQuery("from User").getResultList();
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   @SuppressWarnings("unchecked")
   public Set<Role> getRoles() {
      return new HashSet<Role>(entityManager.createQuery("from Role").getResultList());
   }

   @Override
   public User getUserByUserName(String username) {
      return (User)entityManager.createQuery("from User where username =: username").setParameter("username", username).getSingleResult();
   }

}
