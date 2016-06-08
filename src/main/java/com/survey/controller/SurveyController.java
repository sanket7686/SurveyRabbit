package com.survey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.dao.service.QuestionService;
import com.survey.dao.service.SurveyQuestionService;
import com.survey.dao.service.SurveyService;
import com.survey.dao.service.UserService;
import com.survey.model.Question;
import com.survey.model.QuestionType;
import com.survey.model.Role;
import com.survey.model.Survey;
import com.survey.model.User;

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

   @RequestMapping("/composer")
   public String composer(@RequestParam(value = "name", required = false, defaultValue = "composer") String name,
         Model model) {
      model.addAttribute("name", name);
      return "composer";
   }

   @RequestMapping(value = "/survey/create/old")
   @ResponseBody
   public String createSurveyOld(@ModelAttribute Survey survey, @ModelAttribute ArrayList<Question> questions, Model model) {
      Question q1 = new Question();
      q1.setCaption("what is your age?");
      q1.setOptions("20-30,30-40,50-100");
      q1.setType(QuestionType.SINGLE);
      
      Question q2 = new Question();
      q2.setCaption("What are your hobbies?");
      q2.setOptions("nothing,sleeping,eating");
      q2.setType(QuestionType.MULTI);
      
      Survey s = new Survey("My survey");
      s.addQuestion(q2);
      s.addQuestion(q1);
      
      sqService.addSurveyQuestion(s);
      
      return "added";
   }
   
   @RequestMapping(value = "/survey/create")
   @ResponseBody
   public String createSurvey(@ModelAttribute Survey survey, Model model) {
      sqService.addSurveyQuestion(survey);
      model.addAttribute("result", "Survey Added");
      return "added";
   }
   
   @RequestMapping(value = "/survey/get")
   @ResponseBody
   public String getSurvey(@RequestParam(value = "id") int id) {
      Survey survey = surveyService.getSurvey(id);
      
      return survey.getSurveyName() + " and no of question are: " + survey.getQuestionList().size();
   }
   
   @RequestMapping(value = "/survey/start")
   public String startSurvey(@RequestParam(value = "id") int id, Model model) {
      Survey survey = surveyService.getSurvey(id);
      model.addAttribute("survey", survey);
      return "survey";
   }
   
}
