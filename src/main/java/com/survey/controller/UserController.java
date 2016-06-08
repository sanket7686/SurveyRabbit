package com.survey.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.survey.dao.service.QuestionService;
import com.survey.dao.service.SurveyQuestionService;
import com.survey.dao.service.SurveyService;
import com.survey.dao.service.UserService;
import com.survey.model.Role;
import com.survey.model.Survey;
import com.survey.model.User;

@Controller
@ComponentScan("com.survey.dao")
public class UserController {

   @Autowired
   UserService userService;

   @Autowired
   SurveyService surveyService;

   @Autowired
   QuestionService questionService;

   @Autowired
   SurveyQuestionService sqService;

   @RequestMapping("/create")
   public String createUser(Model model) {
      User user1 = new User("author1", "password", Role.AUTHOR);
      userService.addPerson(user1);

      User user2 = new User("author2", "password", Role.AUTHOR);
      userService.addPerson(user2);

      User user3 = new User("grader1", "password", Role.GRADER);
      userService.addPerson(user3);

      User user4 = new User("grader2", "password", Role.GRADER);
      userService.addPerson(user4);

      List<User> users = userService.fetchAllPersons();

      StringBuffer allUsers = new StringBuffer();
      for (User user : users) {
         allUsers.append(user.getUsername());
         allUsers.append("\n");
      }

      model.addAttribute("name", allUsers.toString());
      return "home";
   }

   @RequestMapping("/login")
   public String login(@RequestParam(value = "name", required = false, defaultValue = "composer") String name,
         Model model) {
      model.addAttribute("user", new User());
      return "login";
   }

   @RequestMapping(value = "/login/validate", method = RequestMethod.POST)
   public String loginValidate(@ModelAttribute User user, Model model, HttpServletRequest request) {
      User loggedInUser = userService.validateLogin(user.getUsername(), user.getPasswordHash());
      if (loggedInUser != null) {
         List<Survey> surveys = (List<Survey>) surveyService.getAllSurveys();
         model.addAttribute("user", loggedInUser);
         model.addAttribute("surveys", surveys);

         return "home";
      } else {
         return "login";
      }
   }

}
