package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.minilabs.ImageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Image {
    @GetMapping("/image")
    public String image(Model model) {
        String web_server = "https://csa.nighthawkcodingsociety.com";
        List<ImageInfo> lii = new ArrayList<>();

        String file0 = "/static/images/donut.png";
        lii.add(new ImageInfo(file0, file0,12));
        lii.get(0).read();

        String file1 = "/images/bulb_on.gif";
        lii.add(new ImageInfo(file1, web_server+file1, 2));
        lii.get(1).read();

        String file2 = "/images/bulb_off.png";
        lii.add(new ImageInfo(file2, web_server+file2, 7));
        lii.get(2).read();

        model.addAttribute("lii", lii);
        return "image";
    }
}
