package com.example.sping_portfolio.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/leaderboard")
public class LeaderboardController<listLeaderboard> {

    private List<Leaderboard> listLeaderboard;

    @PostConstruct
    private void loadData()
    {
        Leaderboard cont1=new Leaderboard("Glazed", "Dunkin Donuts", "4.5");

        listLeaderboard=new ArrayList<>();

        listLeaderboard.add(cont1);
    }

    @GetMapping("/topten")
    public String showLeaderboard(Model model)
    {

        model.addAttribute("leaderboard", listLeaderboard);
        return "leaderboard";
    }
}

