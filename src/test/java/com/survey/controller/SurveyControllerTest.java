package com.survey.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.survey.model.Question;
import com.survey.model.QuestionType;
import com.survey.model.Survey;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class SurveyControllerTest {

   @Mock
   SurveyController controller;
   
   @Before
   public void init(){
      MockitoAnnotations.initMocks(this);
   }
   
   @Test
   public void testInitializer(){
      Survey s = new Survey("sample");
      s.addQuestion(new Question("how old are you?", "10,20,30", QuestionType.SINGLE));
      Mockito.when(controller.getSurvey(1)).thenReturn(s);
      
      Assert.assertEquals(1, controller.getSurvey(1).getQuestionList().size());
   }
   
}
