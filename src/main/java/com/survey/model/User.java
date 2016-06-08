package com.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(name="username")  
   private String username;

   @Column(name="password")
   private String passwordHash;

   @Column(name="role")
   private Role role;
   
   public User(){
      
   }

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
   
   public boolean isAuthor() {
      if(this.role == Role.AUTHOR){
         return true;
      }
      return false;
   }
   
   public boolean isGrader() {
      if(this.role == Role.GRADER){
         return true;
      }
      return false;
   }

}
