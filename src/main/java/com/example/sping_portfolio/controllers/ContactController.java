package com.example.sping_portfolio.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sping_portfolio.controllers.Contact;

@Controller

public class ContactController {

    private List<Contact> listContacts;

    @PostConstruct
    private void loadData()
    {
    //create an object by creating an instance in the class
        Contact cont1=new Contact("Eshaan","Parlikar","(858)705-3900","parlikareshaan@gmail.com");
        Contact cont2=new Contact("Navodit","Maheshwari","(858)216-5147","navoditmaheshwari@gmail.com");
        Contact cont3=new Contact("Ak","Prathipati","(858)213-8198","akprathipati@gmail.com");
        Contact cont4=new Contact("Kevin","Do","(858)381-7563","kevin12345do@gmail.com");

        listContacts=new ArrayList<>();

        listContacts.add(cont1);
        listContacts.add(cont2);
        listContacts.add(cont3);
        listContacts.add(cont4);

    }

    @GetMapping("/contacts")
    public String showContacts(Model model)
    {

        model.addAttribute("contacts", listContacts);
        return "contact-list";
    }
}
