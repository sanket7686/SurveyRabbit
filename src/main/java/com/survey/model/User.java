package com.survey.model;

public class User {

   private String username;

   private String passwordHash;

   private Role role;

   public User(String username, String passwordHash, Role role) {
      super();
      this.username = username;
      this.passwordHash = passwordHash;
      this.role = role;
   }

   public Role getRole() {
      return role;
   }

   public void setRole(Role role) {
      this.role = role;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPasswordHash() {
      return passwordHash;
   }

   public void setPasswordHash(String passwordHash) {
      this.passwordHash = passwordHash;
   }

   //TODO: Add logic to save survey
   public boolean saveSurvey(Survey s) {
      return false;
   }
}
