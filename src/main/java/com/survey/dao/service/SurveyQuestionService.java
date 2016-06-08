package com.survey.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.QuestionDao;
import com.survey.dao.SurveyDao;
import com.survey.model.Survey;

@Component
public class SurveyQuestionService {

   @Autowired
   private QuestionService questionService;

   @Autowired
   private SurveyService surveyService;

   public void addSurveyQuestion(Survey s) {
      surveyService.addSurvey(s);
      questionService.addQuestions(s.getQuestionList());
   }

}
