package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.demo.model.Person;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/test", produces=MediaType.TEXT_HTML_VALUE)
public class IndexController {
    Logger logger = Logger.getLogger(IndexController.class.getName());

    @RequestMapping("/currtime")
    public String index(Model model) {
        logger.log(Level.INFO, "current date time");
        model.addAttribute("currTime", new Date().toString());
        return "index";
    }

    @RequestMapping("/person")
    public String allStudent(Model model){
        List<Person> allPerson = new ArrayList<Person>();
        Person p = new Person();
        p.setId(1);
        p.setName("Kenneth");
        p.setGender('F');
        allPerson.add(p);
        Person p2 = new Person();
        p2.setId(2);
        p2.setName("Alex");
        p2.setGender('M');
        allPerson.add(p2);
        // logic to build student data
        model.addAttribute("person", allPerson);
        model.addAttribute("currDatetime", new Date().toString());
        return "person";
    }
}
