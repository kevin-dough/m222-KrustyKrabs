package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.minilabs.ImageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Grayscale {
    @GetMapping("/image/grayscale")
    public String grayscale(Model model){
        String web_server = "https://csa.nighthawkcodingsociety.com";
        List<ImageInfo> lii = new ArrayList<>();

        String[] file = {"/images/donut.png"};

        for (int ii = 0; ii<file.length; ii++) {
            lii.add(new ImageInfo(file[ii], web_server+file[ii], 12));
//        String str = lii.get(0).grayscale();
            model.addAttribute("str" + ii, lii.get(ii).grayscale());
        }
        return "grayscale";
    }
}

