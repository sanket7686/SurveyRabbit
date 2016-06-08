package com.survey.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Survey")
public class Survey {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int surveyId;

   @Column(name="surveyName")  
   private String surveyName;


   @Column(name="numberOfResponse")  
   private int numberOfResponse = 0;

   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(name = "Survey_Question", joinColumns = { @JoinColumn(name = "surveyId") }, inverseJoinColumns = { @JoinColumn(name = "questionId") })
   private Set<Question> questionList;


   public Survey(String name) {
      this.surveyName = name;
   }
   
   public Survey() {
   }

   public Set<Question> getQuestionList() {
      return questionList;
   }
   
   public void setQuestionList(Set<Question> questionList) {
      this.questionList = questionList;
   }

   public void addQuestion(Question question) {
      if (this.questionList != null) {
         this.questionList.add(question);
      } else {
         this.questionList = new HashSet<>();
         this.questionList.add(question);
      }
   }

   public int getNumberOfResponse() {
      return numberOfResponse;
   }

   public void setNumberOfResponse(int numberOfResponse) {
      this.numberOfResponse = numberOfResponse;
   }

   public void incrementResponses() {
      this.numberOfResponse++;
   }

   public String getSurveyName() {
      return surveyName;
   }

   public void setSurveyName(String surveyName) {
      this.surveyName = surveyName;
   }
   
   public int getSurveyId() {
      return surveyId;
   }

}
