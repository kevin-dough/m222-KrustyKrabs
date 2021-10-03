package com.example.sping_portfolio.eshaan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpoController {
    public List<_ExponentialSequence> ExpoInit(int nth) {
        List<_ExponentialSequence> ExpoList = new ArrayList<>();
        ExpoList.add(new ExpoFor(nth));
        ExpoList.add(new ExpoWhile(nth));
        ExpoList.add(new ExpoRecursion(nth));
        ExpoList.add(new ExpoStream(nth));

        return ExpoList;
    }

    @GetMapping("/eshaan/exposequence")
    public String expo(@RequestParam(name="sequence", required=false,  defaultValue="2") String sequence, Model model) {
        int nth = Integer.parseInt(sequence);
        model.addAttribute("ExpoList", ExpoInit(nth));
        return "eshaan/exposequence";

    }

}