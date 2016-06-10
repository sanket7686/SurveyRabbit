# Survey Rabbit
-------------
This is a demo application to demonstrate design and basic implementation of SurveyRabbit. It is based on SpringBoot, Hibernate and MySQL. 
I chose MySQL because of familiarity, but Hibernate allows replacing database very easily. Hence, Postgres can easily be substituted

## Architecture
Client --> Controller --> Service Layer --> DAO --> Database

## Application Structure
1. Model [link](https://github.com/sanket7686/SurveyRabbit/tree/master/src/main/java/com/survey/model)
2. Controller [link](https://github.com/sanket7686/SurveyRabbit/tree/master/src/main/java/com/survey/controller)
3. Views [link] (https://github.com/sanket7686/SurveyRabbit/tree/master/src/main/resources/templates)
4. Service [link] (https://github.com/sanket7686/SurveyRabbit/tree/master/src/main/java/com/survey/dao/service)
5. DAO [link] (https://github.com/sanket7686/SurveyRabbit/tree/master/src/main/java/com/survey/dao)

## How to run this project?
+ Start MySQL and import [dump file](https://github.com/sanket7686/SurveyRabbit/blob/master/SurveyRabbitDump.sql) 
+ Run application in command line. (Download JAR file from [here](https://github.com/sanket7686/SurveyRabbit/blob/master/SurveyRabbit-0.1.0.jar))
```
java -jar SurveyRabbit-0.1.0.jar
```
+ Hit in browser, http://localhost:8080/login (I started implementing front end and then realised, it wasn't required)
+ Login using any of the following users and password is "password"
  -author1
  -grader1


## REST API's

+ This API gives all the available survey
```
/survey/get/all
```

+ This API gives details about a survey based on the Id
```
/survey/get?id=6
```
```javascript
SAMPLE RESPONSE
{
  surveyId: 6,
  surveyName: "My survey",
  numberOfResponse: 0,
  questionList: [
  {
    questionId: 11,
    caption: "What are your hobbies?",
    options: "nothing,sleeping,eating",
    type: "MULTI",
    optionList: [
      "nothing,sleeping,eating"
    ]
  },
  {
    questionId: 12,
    caption: "what is your age?",
    options: "20-30,30-40,50-100",
    type: "SINGLE",
    optionList: [
    "20-30,30-40,50-100"
    ]
  }
  ]
}
```

## Future Enahncements
1. Session and Login management using Spring security
2. Develop screens using ThymeLeaf
3. Save and retrieve responses
4. Securing application



