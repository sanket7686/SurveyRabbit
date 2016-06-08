package com.survey.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.UserDao;
import com.survey.model.Role;
import com.survey.model.User;

@Component
public class UserService {

   private UserDao userDao;

   public UserDao getUserDao() {
      return userDao;
   }

   @Autowired
   public void setPersonDao(UserDao userDao) {
      this.userDao = userDao;
   }

   public void addPerson(User person) {
      getUserDao().insert(person);
   }

   public List<User> fetchAllPersons() {
      return getUserDao().getAllUsers();
   }
   
   public User getUserbyUsername(String userName){
      return getUserDao().getUserByUserName(userName);
   }
   
   public User validateLogin(String userName, String passwordHash){
      return getUserDao().validateLogin(userName, passwordHash);
   }
   
}
