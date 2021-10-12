package com.example.sping_portfolio.minilabs;

import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;

import java.awt.image.DataBufferByte;
import java.io.*;
import java.net.URL;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

@Getter
public class ImageInfo{
    public int height, s_height;
    public int width, s_width;
    public int scale;
    public int[][][] m_rgb;
    public String file, url;

    public ImageInfo(String file, String url, int scale) {
        this.file = file;
        this.url = url;
        this.scale = scale;
    }

    public Exception read(){
        try{
            BufferedImage img = ImageIO.read(new URL(this.url));
            this.height = img.getHeight();
            this.s_height = this.height / scale;
            this.width = img.getWidth();
            this.s_width = this.width / scale;
            //System.out.println(Integer.toString(this.height) + " " + Integer.toString(this.width));
            this.m_rgb = new int[this.height][this.width][3];

            for (int y=0; y < this.height; y++){
                for(int x=0; x < this.width; x++){
                    int pixel = img.getRGB(x, y);
                    Color color = new Color(pixel, true);

                    this.m_rgb[y][x][0] = color.getRed();
                    this.m_rgb[y][x][1] = color.getGreen();
                    this.m_rgb[y][x][2] = color.getBlue();
                }
            }

        } catch (Exception e) {
            return e;
        }

        return null;
    }

    // grayscale method
    // return: base64 in grayscale
    public String greyscale() {
        try {
            BufferedImage img = ImageIO.read(new URL(url)); // Saving internet image to BufferedImage
            byte[] pixels = image_to_pixels(img); // See method definition
            int[] pixels_int = grayscale(pixels);
            String base64 = pixels_to_base64(img.getWidth(), img.getHeight(), pixels_int);
            return "data:image/jpg;base64,"+base64;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    // grayscale pixel manipulator
    public int[] grayscale(byte[] pixels){
        int[] pixels_int = new int[pixels.length];
        for(int i=0;i<pixels.length;i+=4) {
            float val = 0;
            for(int y=1;y<4;y++) {
                val += (pixels[i+y] & 0xFF)/3.0;
            }
            pixels_int[i+0] = pixels[i];
            pixels_int[i+1] = (int)val;
            pixels_int[i+2] = (int)val;
            pixels_int[i+3] = (int)val;
        }
        return pixels_int;
    }

    // image to byte array of pixels
    public byte[] image_to_pixels(BufferedImage img) throws IOException {
        byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        return pixels;
    }

    public String pixels_to_base64(int width, int height, int[] pixels) throws IOException {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a, r, g, b;
                int s = (y * width + x) * 4;
                a = pixels[s];
                r = pixels[s + 1];
                g = pixels[s + 2];
                b = pixels[s + 3];
                img.setRGB(x, y, argb(a, r, g, b));
            }
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", bos);
        byte[] data = bos.toByteArray();
        return Base64.encodeBase64String(data);
    }

    // building rgba image data
    public int argb(int a, int r, int g, int b) {
        return ((a&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
    }

    public int gets_height(int row) {
        return row * this.scale;
    }

    public int gets_width(int col){
        return col * this.scale;
    }

    public String getRGB(int row, int col) {
        int h = row * this.scale;
        int w = col * this.scale;
        return "(" + m_rgb[h][w][0] +
                "," + m_rgb[h][w][1] +
                "," + m_rgb[h][w][2] +
                ")" ;
    }

    public String getHexCode(int row, int col) {
        int h = row * this.scale;
        int w = col * this.scale;
        // String.format guarantees 0 padding vs Integer.toHexString
        return "#" +
                String.format("%02X",m_rgb[h][w][0]) +
                String.format("%02X",m_rgb[h][w][1]) +
                String.format("%02X",m_rgb[h][w][2]) ;
    }

    public String getBinary(int row, int col) {
        int h = row * this.scale;
        int w = col * this.scale;
        // Java does not have binary as string formatter
        return  String.format("%8s", Integer.toBinaryString(m_rgb[h][w][0])).replace(' ', '0') +
                " " +
                String.format("%8s", Integer.toBinaryString(m_rgb[h][w][1])).replace(' ', '0') +
                " " +
                String.format("%8s", Integer.toBinaryString(m_rgb[h][w][2])).replace(' ', '0') ;
    }

    public String[] convert_to_ascii(){
        int[][] gs = this.to_grayscale();
        int[][] scaled_gs = this.gscale(gs);
        //return  this.to_ascii_array(scaled_gs);
        return new String[1];
    }

    public int[][] to_grayscale(){
        // grey scale is calculated to average of pixel
        int[][] gs = new int[height][width];
        for (int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                int r = this.m_rgb[h][w][0];
                int g = this.m_rgb[h][w][1];
                int b = this.m_rgb[h][w][2];
                // averaging
                int avg = (r+g+b) /3;
                gs[h][w] = avg;
            }
        }
        return gs;
    }

    public int[][] gscale(int[][] gs){
        // scale image down by scale_factor
        int w_scaled = width /scale;
        int h_scaled = height /scale;

        int[][] gscaled = new int[h_scaled][w_scaled];
        for(int w=0; w<w_scaled; w++){
            for(int h=0; h<h_scaled; h++){ //looping over blocks

                int sum = 0;
                for(int x=(w)*scale; x<(w+1)*scale; x++){ //looping over the induvidual coordinates in block
                    for(int y=(h)*scale; y<(h+1)*scale; y++){
                        //System.out.println("("+Integer.toString(x)+", "+Integer.toString(y)+")");
                        sum = sum + gs[y][x];
                    }
                } //end loop 2

                gscaled[h][w] = sum /(scale*scale);

            }
        } //end loop 1
        //System.out.println(Arrays.deepToString(scaled));
        return gscaled;
    }

}
