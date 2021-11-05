package com.example.sping_portfolio.minilabs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import java.util.Scanner;

@Controller
public class averger {
    @GetMapping("/averager")
    public String alphabet() {
        return "averager";
    }

    @PostMapping("/averager")
    @ResponseBody
    public String alphabetize(
            @RequestParam String listInput
    ) {
        float total=0, avg;

        String [] a = listInput.split(" ");

        for (String i : a) {
            total = total + Integer.parseInt(i);
        }

        //Average calculation here
        avg = total/6;
        String message = "";
        System.out.print("Final rating: ");
        if(avg>=4.5)
        {
            message = "Awesome! EAT EAT EAT!";
        }
        else if(avg>=4 && avg<3.5)
        {
            message="Good! You should try it!";
        }
        else if(avg>=3 && avg<3.9999)
        {
            message = "Decent! You might wanna try!";
        }
        else
        {
            message = "Crap! Don't eat it, least popular!";
        }

        return "Average: " + avg + "  //  " + message;
    }
}
