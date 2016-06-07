package com.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {

    @RequestMapping("/home")
    public String home(@RequestParam(value="name", required=false, defaultValue="home") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
    
    @RequestMapping("/survey")
    public String survey(@RequestParam(value="name", required=false, defaultValue="survey") String name, Model model) {
        model.addAttribute("name", name);
        return "survey";
    }
    
    @RequestMapping("/composer")
    public String composer(@RequestParam(value="name", required=false, defaultValue="composer") String name, Model model) {
        model.addAttribute("name", name);
        return "composer";
    }

}
