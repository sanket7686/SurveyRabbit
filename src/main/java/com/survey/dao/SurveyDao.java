package com.survey.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.survey.model.Survey;

@Repository
@Transactional
public class SurveyDao {

   private SessionFactory sessionFactory;

   public SessionFactory getSessionFactory() {
      return sessionFactory;
   }

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public void insert(Survey survey) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      session.save(survey);
      session.getTransaction().commit();
      //return survey.getSurveyId();
   }

   public List<Survey> getAllSurveys() {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(Survey.class);
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);      
      
      List<Survey> surveys = (List<Survey>) criteria.list();
      session.getTransaction().commit();
      return surveys;
   }
   
   public Survey getSurveyById(int id) {
      Session session = getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(Survey.class);
      criteria.add(Restrictions.eq("surveyId", id));
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);      

      List<Survey> surveys = (List<Survey>) criteria.list();
      session.getTransaction().commit();
      return surveys.get(0);
   }
   
   
}
