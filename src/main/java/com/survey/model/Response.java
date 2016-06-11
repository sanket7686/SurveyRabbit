package com.survey.model;

//TODO: Implement responses from users
public class Response {

   private Question question;

   private String answer;

   public Question getQuestion() {
      return question;
   }

   public void setQuestion(Question question) {
      this.question = question;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }
}
