package com.survey.controller;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;

@Component
public class HibernateSessionFactoryBean {

   @Bean
   public SessionFactory getSessionFactory(DataSource dataSource) {
      LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
      sessionBuilder.addAnnotatedClasses(User.class);
      sessionBuilder.addAnnotatedClasses(Question.class);
      sessionBuilder.addAnnotatedClasses(Survey.class);
      return sessionBuilder.buildSessionFactory();
  }
}
