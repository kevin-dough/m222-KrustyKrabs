package com.example.sping_portfolio.minilabs;

import java.util.Scanner;

public class Hackathon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double score1, score2, score3, score4, gp1, gp2, fscore, sum, avg1, avg2, totavg;

        System.out.println("Please enter the value of the first score for Group 1:");
        score1 = in.nextDouble();
        System.out.println("Please enter the second score for Group 1:");
        score2 = in.nextDouble();
        gp1 = score1 + score2;
        avg1 = gp1/2;
        System.out.println("This is Group 1's average score:" + " " + avg1);
        System.out.println("Please enter the value of the first score for Group 2:");
        score3 = in.nextDouble();
        System.out.println("Please enter the second score for Group 2:");
        score4 = in.nextDouble();
        gp2 = score3 + score4;
        avg2 = gp2/2;
        System.out.println("This is Group 2's average score:" + " " + avg2);
        System.out.println("Please enter the score for the final test:");
        fscore = in.nextDouble();
        sum = gp1 + gp2 + fscore;
        totavg = sum/5;
        System.out.println("The total average across all scores is:" + " " + totavg);




    }
}
