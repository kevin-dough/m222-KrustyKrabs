package com.example.sping_portfolio.kevin.ascii;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.lang.Integer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class ascii {
    @GetMapping("/kevin/asciilab")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String asciiart() {
        return "kevin/ascii";
    }

    public char[] charList = {' ', '.', ',', ';', '}', '+', '=', '$', '&', '%', '#', '@'};
    @PostMapping("/kevin/asciilab")
    @ResponseBody
    public String asciiUpload(@RequestParam(name="inputFile") MultipartFile imageData, Model model){
        BufferedImage img;
        int[] rgbArray;
        int imgWidth;
        int imgHeight;
        int width;
        int height;

        try {
            img = createImageFromBytes(imageData.getBytes());
            imgWidth = img.getWidth();
            imgHeight = img.getHeight();
            rgbArray = new int[imgWidth * imgHeight];
            img.getRGB(0, 0, imgWidth, imgHeight, rgbArray, 0, imgWidth);
        } catch(IOException e) {
            System.out.println(e);
            return e.toString();
        }
        System.out.println("imgWidth: " + imgWidth);
        System.out.println("imgHeight: " + imgHeight);

        char[][] asciiArt = new char[imgHeight][imgWidth];

        int moveY = 0, moveX = 0;

        for(int y = 0; y < imgHeight; y++) {
            for(int x = 0; x < imgWidth; x++) {
                asciiArt[y][x] = ConvertToChar(
                        rgbArray[(int) (Math.floor(moveY) * imgWidth) + (int) Math.floor(moveX)]
                );
                moveX += 1;
            }
            moveX = 0;
            moveY += 1;
        }

        String f = "";

        for(char ch[] : asciiArt) {
            f += new String(ch);
            f += "\n";
        }
        System.out.println(f);
        model.addAttribute("export", f);

        return f;
    }

    private char ConvertToChar(int argb) {
        float lightLevel = grayScale(argb) / 255.0f;

        return charList[(int) Math.floor(lightLevel * (charList.length - 1))];
    }

    int grayScale(int rgb) {
        // int alpha = (rgb >> 24) & 0xFF; // not going to process alpha channel
        int red   = (rgb >> 16) & 0xFF;
        int green = (rgb >>  8) & 0xFF;
        int blue  = (rgb      ) & 0xFF;
        int linear = Math.round(red * 0.2126f + green * 0.7152f + blue * 0.0722f);
        return linear;
    }

    private BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}