package com.survey.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.SurveyDao;
import com.survey.model.Survey;

@Component
public class SurveyService {

   private SurveyDao surveyDao;

   public SurveyDao getSurveyDao() {
      return surveyDao;
   }

   @Autowired
   public void setSurveyDao(SurveyDao surveyDao) {
      this.surveyDao = surveyDao;
   }

   public void addSurvey(Survey survey) {
      getSurveyDao().insert(survey);
   }

   public List<Survey> getAllSurveys() {
      return getSurveyDao().getAllSurveys();
   }
   

   public Survey getSurvey(int id) {
      return getSurveyDao().getSurveyById(id);
   }
   
   
}
