package com.example.sping_portfolio.minilabs;

import java.util.Scanner;

public class averger
{
    public static void main(String args[])
    {
        int marks[] = new int[6];
        int i;
        float total=0, avg;
        Scanner scanner = new Scanner(System.in);


        for(i=0; i<6; i++) {
            System.out.print(" Rating(OUT OF 5)"+(i+1)+":");
            marks[i] = scanner.nextInt();
            total = total + marks[i];
        }
        scanner.close();
        //Average calculation here
        avg = total/6;
        System.out.print("Final rating: ");
        if(avg>=4.5)
        {
            System.out.print("Awesome(EAT EAT EAT!)");
        }
        else if(avg>=4 && avg<3.5)
        {
            System.out.print("Good(should try) ");
        }
        else if(avg>=3 && avg<3.9999)
        {
            System.out.print("Decent(Average might wanna try)");
        }
        else
        {
            System.out.print("Crap(dont eat, least popular)");
        }
    }
}
