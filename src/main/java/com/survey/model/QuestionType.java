package com.survey.model;

public enum QuestionType {

   SINGLE(0), MULTI(1);

   private int value;

   private QuestionType(int value) {
      this.value = value;
   }
}
