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

@RequestMapping("/contacts")
public class ContactController {

    private List<Contact> listContacts;

    @PostConstruct
    private void loadData()
    {

        Contact cont1=new Contact("Eshaan","Parlikar","(858)705-3900","parlikareshaan@gmail.com");
        Contact cont2=new Contact("Eshaan","Parlikar","(858)705-3900","parlikareshaan@gmail.com");
        Contact cont3=new Contact("Eshaan","Parlikar","(858)705-3900","parlikareshaan@gmail.com");
        Contact cont4=new Contact("Eshaan","Parlikar","(858)705-3900","parlikareshaan@gmail.com");

        listContacts=new ArrayList<>();

        listContacts.add(cont1);
        listContacts.add(cont2);
        listContacts.add(cont3);
        listContacts.add(cont4);

    }

    @GetMapping("/contactlist")
    public String showContacts(Model model)
    {

        model.addAttribute("contacts", listContacts);
        return "contact-list";
    }
}
