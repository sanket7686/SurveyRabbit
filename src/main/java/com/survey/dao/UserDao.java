package com.survey.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.survey.model.Role;
import com.survey.model.User;

@Repository
@Transactional
public class UserDao {

   private SessionFactory sessionFactory;

   public SessionFactory getSessionFactory() {
      return sessionFactory;
   }

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public void insert(User user) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      session.save(user);
      session.getTransaction().commit();

   }

   public List<User> getAllUsers() {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(User.class);
      List<User> persons = (List<User>) criteria.list();
      session.getTransaction().commit();
      return persons;
   }
   
   public User getUserByUserName(String userName) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(User.class);
      criteria.add(Restrictions.eq("username", userName));
      List<User> persons = (List<User>) criteria.list();
      session.getTransaction().commit();
      return persons.get(0);
   }
   
   public User validateLogin(String userName, String passwordHash) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(User.class);
      criteria.add(Restrictions.eq("username", userName));
      criteria.add(Restrictions.eq("passwordHash", passwordHash));

      List<User> persons = (List<User>) criteria.list();
      session.getTransaction().commit();
      if(persons.size() > 0){
         return persons.get(0);
      }
      return null;
   }
   
   
}
