package com.survey.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.survey.model.Question;

@Repository
@Transactional
public class QuestionDao {

   private SessionFactory sessionFactory;

   public SessionFactory getSessionFactory() {
      return sessionFactory;
   }

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public void insert(Question question) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      session.save(question);
      session.getTransaction().commit();

   }

   public void insertQuestions(Set<Question> questions) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      for (Question q : questions) {
         session.save(q);
      }
      session.getTransaction().commit();

   }
   public List<Question> getAllQuestions() {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(Question.class);
      List<Question> questions = (List<Question>) criteria.list();
      session.getTransaction().commit();
      return questions;
   }
   
}
