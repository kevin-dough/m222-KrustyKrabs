package com.example.sping_portfolio.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sping_portfolio.controllers.About;

@Controller

public class AboutController {

    private List<About> listAbout;

    @PostConstruct
    private void loadData()
    {
        //create an object by creating an instance in the class
        About person1=new About("kevin","Cherry Glaze");
        About person2=new About("ak","Sugar Donut");
        About person3=new About("navodit","Original Glaze");
        About person4=new About("eshaan","Vanilla Sprinkle");

        listAbout=new ArrayList<>();

        listAbout.add(person1);
        listAbout.add(person2);
        listAbout.add(person3);
        listAbout.add(person4);

    }

    @GetMapping("/about")
    public String showAbout(Model model)
    {

        model.addAttribute("about", listAbout);
        return "about";
    }
}