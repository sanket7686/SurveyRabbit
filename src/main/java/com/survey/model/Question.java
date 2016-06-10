package com.survey.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long questionId;

   @Column(name="caption")  
   private String caption;

   //This stores comma separated list of options
   @Column(name="options")  
   private String options;

   @Column(name="question_type")  
   private QuestionType type;

   public Question() {

   }

   public Question(String caption, String options, QuestionType type) {
      this.caption = caption;
      this.options = options;
      this.type = type;
   }

   public QuestionType getType() {
      return type;
   }

   public void setType(QuestionType type) {
      this.type = type;
   }

   public String getOptions() {
      return options;
   }

   public void setOptions(String options) {
      this.options = options;
   }

   public String getCaption() {
      return caption;
   }

   public void setCaption(String caption) {
      this.caption = caption;
   }

   public List<String> getOptionList() {
      return new ArrayList<String>(Arrays.asList(options.split(" , ")));
   }
   
   public long getQuestionId() {
      return questionId;
   }

   public void setQuestionId(long questionId) {
      this.questionId = questionId;
   }
}
