package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class About {

    @GetMapping("/about")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String about(Model model) {

        String[] name = new String[] { "Kevin", "Ak", "Navodit", "Eshaan" };

        model.addAttribute("name", name);

        String[] donut = new String[] { "Glazed", "Example", "Example", "Example" };

        model.addAttribute("donut", donut);

        return "about"; // returns HTML VIEW (greeting)
    }
}

