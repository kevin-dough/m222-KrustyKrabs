package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;



@Controller
public class Leaderboard {
    private String name;
    private String store;
    private String rating;


    public Leaderboard()
    {

    }

    public Leaderboard(String name, String store, String rating) {
        this.name = name;
        this.store = store;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Leaderboard [Donut=" + name + ", Store=" + store + ",Rating" + rating + "]";
    }
}
