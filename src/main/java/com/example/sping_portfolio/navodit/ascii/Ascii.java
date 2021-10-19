package com.example.sping_portfolio.navodit.ascii;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

public class Ascii {

    private BufferedImage img;


    {
        try {
            img = ImageIO.read(new File("/Users/navoditmah/IdeaProjects/m222-KrustyKrabs/src/main/resources/static/images/smile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double pixval;
    private PrintWriter prntwrt;
    private FileWriter filewrt;

    public Ascii() {
        try {
            prntwrt = new PrintWriter(filewrt = new FileWriter("/Users/navoditmah/IdeaProjects/m222-KrustyKrabs/src/main/resources/static/images/ascii.txt",
                    true));
        } catch (IOException ex) {
        }
    }

    public void convert(String imgname) {
        try {
            img = ImageIO.read(new File(imgname));
            img=  resize(img, img.getWidth()/20, img.getHeight()/20);
        } catch (IOException e) {
        }

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color pixcol = new Color(img.getRGB(j, i));
                pixval = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol
                        .getGreen() * 0.11)));
                print(strChar(pixval));
            }
            try {
                prntwrt.println("");
                prntwrt.flush();
                filewrt.flush();
            } catch (Exception ex) {
            }
        }
    }

    public String strChar(double g) {
        String str = " ";
        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }

    public void print(String str) {
        try {
            prntwrt.print(str);
            prntwrt.flush();
            filewrt.flush();
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) {
        Ascii obj = new Ascii();
        obj.convert("/Users/navoditmah/IdeaProjects/m222-KrustyKrabs/src/main/resources/static/images/smile.png");
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
