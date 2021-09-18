package com.example.sping_portfolio.minilabs;

class DeMorgans {
    public static void main(String[] args) {
        boolean issmart = true;
        boolean looksfit = false;

        if (issmart && looksfit){
            System.out.println("You are like Ak (10% chance)");
        }
        else if (!(issmart || !looksfit)){
            System.out.println("You are like Navodit (7% chance)");
        }
        else if (issmart || looksfit){
            System.out.println("You are like Eshaan (17% chance");

        }
        else if (issmart || looksfit){
            System.out.println("You are like Kevin (3.958% chance");
    }

}
}
