package com.survey.model;

public enum Role {

   AUTHOR(0), GRADER(1), ADMIN(100);
   private int value;

   private Role(int value) {
      this.value = value;
   }
}
