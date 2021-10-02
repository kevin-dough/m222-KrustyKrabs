package com.example.sping_portfolio.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlgoController {
    public List<_AlgorithmExtend> AlgoInit(int nth) {
        List<_AlgorithmExtend> AlgoList = new ArrayList<>();
        AlgoList.add(new AlgoFor(nth));
        AlgoList.add(new AlgoWhile(nth));
        AlgoList.add(new AlgoRecursion(nth));
        AlgoList.add(new AlgoStream(nth));

        return AlgoList;
    }

    @GetMapping("/kevin/algos")
    public String algo(@RequestParam(name="sequence", required=false,  defaultValue="2") String sequence, Model model) {
        int nth = Integer.parseInt(sequence);
        model.addAttribute("AlgoList", AlgoInit(nth));
        return "kevin/algos";

    }

}