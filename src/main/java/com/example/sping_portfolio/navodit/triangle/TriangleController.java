package com.example.sping_portfolio.navodit.triangle;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
 public class TriangleController{
    public List<_Triangle> TrigInit(int nth) {
        List<_Triangle> TrigList = new ArrayList<>();
        TrigList.add(new TrigFor(nth));
        TrigList.add(new TrigWhile(nth));
        TrigList.add(new TrigRecurse(nth));
        TrigList.add(new TrigStream(nth));

        return TrigList;
    }

    @GetMapping("/navodit/triangle")
    public String trig(@RequestParam(name="sequence", required=false,  defaultValue="2") String sequence, Model model){
        int nth = Integer.parseInt(sequence);
        model.addAttribute("TrigList", TrigInit(nth));
        return "navodit/triangle";}

}