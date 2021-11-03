package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class IndividualDonutController {

    @GetMapping("/donut/{donutname}")
    public String donut(@PathVariable("donutname") String donutname, Model model) {

        System.out.println(donutname);

        Donuts glazed = new Donuts();
        Donuts burnt = new Donuts();
        Donuts thedonut = new Donuts();

        if(Objects.equals(donutname, "glazed"))
            thedonut = glazed;
        if(Objects.equals(donutname, "burnt"))
            thedonut = burnt;

        //glazed
        glazed.setName("Original Glazed");
        glazed.setRating(3.6); //rating can't be 4.5 or above because thymeleaf loops are so weird and don't have good functionality
        glazed.setImage("glazed_donut.png");
        glazed.setTag1("glazed");
        glazed.setTag2("og");
        glazed.setTag3("delicious");
        glazed.setTag4("starter");

        //burnt
        burnt.setName("Burnt Donut");
        burnt.setRating(3.2);
        burnt.setImage("burnt_donut.png");
        burnt.setTag1("charcoal");
        burnt.setTag2("smoke");
        burnt.setTag3("ash");
        burnt.setTag4("powder");

        long rounded = Math.round(thedonut.getRating());
        Integer roundedRating = (int) rounded;
        Integer noStars = 5 - roundedRating;

        System.out.println("pink stars: " + roundedRating);
        System.out.println("grey stars: " + noStars);

        model.addAttribute("name", thedonut.getName());
        model.addAttribute("image", thedonut.getImage());
        model.addAttribute("rating", thedonut.getRating());
        model.addAttribute("roundedRating", roundedRating.toString());
        model.addAttribute("noStars", noStars.toString());
        model.addAttribute("tag1", thedonut.getTag1());
        model.addAttribute("tag2", thedonut.getTag2());
        model.addAttribute("tag3", thedonut.getTag3());
        model.addAttribute("tag4", thedonut.getTag4());
        return "individualDonut";
    }

    public static class Donuts {

        private String name;
        private String image;
        private double rating;
        private String tag1;
        private String tag2;
        private String tag3;
        private String tag4;

        public Donuts() {

        }

        public Donuts(String name, double rating, String image, String tag1, String tag2, String tag3, String tag4) {
            this.name = name;
            this.rating = rating;
            this.image = image;
            this.tag1 = tag1;
            this.tag2 = tag2;
            this.tag3 = tag3;
            this.tag4 = tag4;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTag1() {
            return tag1;
        }

        public void setTag1(String tag1) {
            this.tag1 = tag1;
        }

        public String getTag2() {
            return tag2;
        }

        public void setTag2(String tag2) {
            this.tag2 = tag2;
        }

        public String getTag3() {
            return tag3;
        }

        public void setTag3(String tag3) {
            this.tag3 = tag3;
        }

        public String getTag4() {
            return tag4;
        }

        public void setTag4(String tag4) {
            this.tag4 = tag4;
        }

    }
}

