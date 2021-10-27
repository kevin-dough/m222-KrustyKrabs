package com.example.sping_portfolio.kevin;

import com.example.sping_portfolio.controllers.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Alphabetize {
    @GetMapping("/kevin/alphabetize")
    public String alphabet() {
        return "kevin/alphabetize";
    }

    private List<String> alphaList;
    private List<String> betaList;
    private final String space = " ";

    @PostMapping("/kevin/alphabetize")
    @ResponseBody
    public String alphabetize(
            @RequestParam String listInput,
            @RequestParam(defaultValue = "false") boolean reverseCheck,
            @RequestParam("itemSplitInput") String itemSplitInput
    ) {
        alphaList = new ArrayList<String>();
        betaList = new ArrayList<String>();
        String [] a = listInput.split(" "); // creates an array 'a'

        System.out.println(itemSplitInput);

        for (String i : a) {
            // System.out.println(i);
            alphaList.add(i); // adds each element in the array to an arraylist
        }

        Collections.sort(alphaList); // alphabetizes the arraylist

        StringBuilder output = new StringBuilder("");

        if(reverseCheck) {
            for(int i = alphaList.size() - 1 ; i>=0; i--) {
                betaList.add(alphaList.get(i));
            }
        } else {
            betaList = alphaList;
        }

        String prefix = ""; // first prefix is nothing but will change to a comma and space that is before each word after the first
        for (String i : betaList) { // combines the items of the list together into a StringBuilder which will be converted in to a string
            output.append(prefix);
            if(Objects.equals(itemSplitInput, "comma")) {
                prefix = ", ";
            }
            if(Objects.equals(itemSplitInput, "space")) {
                prefix = " ";
            }
            output.append(i);
        }



        return output.toString(); //returns the StringBuilder as a String
    }

}

