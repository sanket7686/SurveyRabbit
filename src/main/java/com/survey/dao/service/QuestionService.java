package com.survey.dao.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.QuestionDao;
import com.survey.model.Question;

@Component
public class QuestionService {

   private QuestionDao questionDao;

   public QuestionDao getQuestionDao() {
      return questionDao;
   }

   @Autowired
   public void setQuestionDao(QuestionDao questionDao) {
      this.questionDao = questionDao;
   }

   public void addQuestion(Question question) {
      getQuestionDao().insert(question);
   }

   public List<Question> getAllQuestions() {
      return getQuestionDao().getAllQuestions();
   }
   
   public void addQuestions(Set<Question> questions){
      getQuestionDao().insertQuestions(questions);
   }
   
}
