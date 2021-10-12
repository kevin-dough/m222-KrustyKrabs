package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.minilabs.ImageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreyscaleController {
    @GetMapping("/image")
    public String image(Model model) {
        String web_server = "https://localhost:8080/";
        List<ImageInfo> lii = new ArrayList<>();

        String image0 = "/images/burnt_donut.png";
        lii.add(new ImageInfo(image0, web_server+image0, 14));
        lii.get(0).read();

        String image1 = "/images/chocglaze.png";
        lii.add(new ImageInfo(image1, web_server+image1, 14));
        lii.get(1).read();

        String image2 = "/images/jelly.png";
        lii.add(new ImageInfo(image2, web_server+image2, 14));
        lii.get(2).read();

        String image3 = "/images/donut.png";
        lii.add(new ImageInfo(image3, web_server+image3, 14));
        lii.get(3).read();

        String image4 = "/images/homer.png";
        lii.add(new ImageInfo(image4, web_server+image4, 14));
        lii.get(4).read();

        String image5 = "/images/bulb_off.png";
        lii.add(new ImageInfo(image5, web_server+image5, 14));
        lii.get(5).read();

        String image6 = "/images/ak.jfif";
        lii.add(new ImageInfo(image6, web_server+image6, 14));
        lii.get(6).read();

        String image7 = "/images/kevin.jfif";
        lii.add(new ImageInfo(image7, web_server+image7, 14));
        lii.get(7).read();

        String image8 = "/images/navodit.jfif";
        lii.add(new ImageInfo(image8, web_server+image8, 14));
        lii.get(8).read();

        String image9 = "/images/eshaan.jfif";
        lii.add(new ImageInfo(image9, web_server+image9, 14));
        lii.get(9).read();

        model.addAttribute("lii", lii);
        return "image";
    }

    @GetMapping("/image/greyscale")
    public String image_greyscale(Model model) {
        String web_server = "http://localhost:8080/";
        List<ImageInfo> lii = new ArrayList<>();

        String image0 = "/images/burnt_donut.png";
        lii.add(new ImageInfo(image0, web_server+image0, 14));
        String str = lii.get(0).greyscale();

        String image1 = "/images/chocglaze.png";
        lii.add(new ImageInfo(image1, web_server+image1, 14));
        String file1 = lii.get(1).greyscale();

        String image2 = "/images/jelly.png";
        lii.add(new ImageInfo(image2, web_server+image2, 14));
        String file2 = lii.get(2).greyscale();

        String image3 = "/images/donut.png";
        lii.add(new ImageInfo(image3, web_server+image3, 14));
        String file3 = lii.get(3).greyscale();

        String image4 = "/images/homer.png";
        lii.add(new ImageInfo(image4, web_server+image4, 14));
        String file4 = lii.get(4).greyscale();

        String image5 = "/images/bulb_off.png";
        lii.add(new ImageInfo(image5, web_server+image5, 14));
        String file5 = lii.get(5).greyscale();

        String image6 = "/images/ak.jfif";
        lii.add(new ImageInfo(image6, web_server+image6, 14));
        String file6 = lii.get(6).greyscale();

        String image7 = "/images/kevin.jfif";
        lii.add(new ImageInfo(image7, web_server+image7, 14));
        String file7 = lii.get(7).greyscale();

        String image8 = "/images/navodit.jfif";
        lii.add(new ImageInfo(image8, web_server+image8, 14));
        String file8 = lii.get(8).greyscale();

        String image9 = "/images/eshaan.jfif";
        lii.add(new ImageInfo(image9, web_server+image9, 14));
        String file9 = lii.get(9).greyscale();

        model.addAttribute("str", str);
        return "greyscale";
    }
}


