package com.survey.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.dao.service.QuestionService;
import com.survey.dao.service.SurveyQuestionService;
import com.survey.dao.service.SurveyService;
import com.survey.dao.service.UserService;
import com.survey.model.Question;
import com.survey.model.QuestionType;
import com.survey.model.Survey;

@Controller
@ComponentScan("com.survey.dao")
public class SurveyController {

   @Autowired
   UserService userService;

   @Autowired
   SurveyService surveyService;

   @Autowired
   QuestionService questionService;

   @Autowired
   SurveyQuestionService sqService;

   @RequestMapping("/survey")
   public String survey(@RequestParam(value = "name", required = false, defaultValue = "survey") String name,
         Model model) {
      model.addAttribute("name", name);
      return "survey";
   }

   @RequestMapping(value = "/survey/create/old")
   @ResponseBody
   public String createSurveyOld(@ModelAttribute Survey survey, @ModelAttribute ArrayList<Question> questions,
         Model model) {
      Question q1 = new Question();
      q1.setCaption("Did you enjoy your dining experience?");
      q1.setOptions("yes,no");
      q1.setType(QuestionType.SINGLE);

      Question q2 = new Question();
      q2.setCaption("What did you order? (check all that apply)");
      q2.setOptions("Soup, Salad, Entree, Desert");
      q2.setType(QuestionType.MULTI);

      Survey s = new Survey("Dining Experience Survey");
      s.addQuestion(q2);
      s.addQuestion(q1);

      sqService.addSurveyQuestion(s);

      return "added";
   }

   @RequestMapping(value = "/survey/create")
   public String createSurvey(@ModelAttribute Survey survey, Model model) {
      sqService.addSurveyQuestion(survey);
      model.addAttribute("result", "Survey Added");
      return "composer";
   }

   @RequestMapping(value = "/survey/create", params = { "addQuestion" })
   public String addRow(final Survey survey, final BindingResult bindingResult, final HttpServletRequest req) {
      String questionType = req.getParameter("addQuestion");
      Question q = new Question();
      if(questionType == QuestionType.SINGLE.name()){
         q.setType(QuestionType.SINGLE);
      }else{
         q.setType(QuestionType.MULTI);
      }
      survey.addQuestion(q);
      return "composer";
   }

   @RequestMapping(value = "/survey/create", params = { "removeQuestion" })
   public String removeRow(final Survey survey, final BindingResult bindingResult, final HttpServletRequest req) {
      int questionId = Integer.valueOf(req.getParameter("removeQuestion"));
      survey.removeQuestion(questionId);
      return "composer";
   }

   @RequestMapping(value = "/survey/create/submit")
   @ResponseBody
   public String submitNewSurvey(@ModelAttribute Survey survey, Model model) {
      sqService.addSurveyQuestion(survey);
      model.addAttribute("result", "Survey Added");
      return "added";
   }

   /**
    * REST API to get survey details based on Id 
    * 
    */
   @RequestMapping(value = "/survey/get")
   @ResponseBody
   public Survey getSurvey(@RequestParam(value = "id") int id) {
      return surveyService.getSurvey(id);
   }

   @RequestMapping(value = "/survey/start")
   public String startSurvey(@RequestParam(value = "id") int id, Model model) {
      Survey survey = surveyService.getSurvey(id);
      model.addAttribute("survey", survey);
      return "survey";
   }

}
