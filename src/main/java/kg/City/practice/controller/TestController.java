package kg.City.practice.controller;



import kg.City.practice.model.Student;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {



    @RequestMapping
    public String getHello() {
        return "index";
    }


}

