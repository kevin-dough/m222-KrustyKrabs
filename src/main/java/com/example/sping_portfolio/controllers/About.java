package com.example.sping_portfolio.controllers;

public class About {
    private String name;
    private String donut;

    public About()
    {

    }

    public About(String name, String donut) {
        //create an attribute
        this.name = name;
        this.donut = donut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDonut() {
        return donut;
    }

    public void setDonut(String donut) {
        this.donut = donut;
    }

    @Override
    public String toString() {
        return "About [name=" + name + ", donut=" + donut + "]";
    }

}
