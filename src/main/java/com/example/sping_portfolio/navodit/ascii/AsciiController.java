//package com.example.sping_portfolio.navodit.ascii;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import com.example.sping_portfolio.minilabs.ImageInfo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
////@Controller
//public class AsciiController {
//    @GetMapping("/navodit/navoascii")
//    public String image(Model model) {
//        String web_server = "https://localhost:8080/";
//        /*String web_server = "https://csa.nighthawkcodingsociety.com";*/
//        List<ImageInfo> lii = new ArrayList<>();
//
//        String image0 = "/images/burnt_donut.png";
//        lii.add(new ImageInfo(image0, web_server + image0, 14));
//        lii.get(0).read();
//
//        model.addAttribute("lii",lii);
//            return "navodit/navoascii";
//        }
//
//    }
//
//}
