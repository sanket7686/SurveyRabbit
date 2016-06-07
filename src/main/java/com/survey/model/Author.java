package com.survey.model;

public class Author extends User {

   public Author(String username, String passwordHash, Role role) {
      super(username, passwordHash, role);
   }

   //TODO: Add logic to edit survey
   public boolean editSurvey(Survey s) {
      return false;
   }

   //TODO: Add logic to create new survey
   public Survey createSurvey() {
      return null;
   }

}
