/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author crhistian
 */
public class Exporter extends Canvas{
    Canvas canvas;
    public Exporter() {
        canvas = new Canvas();
    }
    
    @Override
    public void paint(Graphics g) {
	Graphics2D g2=(Graphics2D)g;
	g2.setBackground(Color.WHITE);
	g2.clearRect(0, 0, this.getWidth(), this.getHeight());
	g2.setColor(Color.BLACK);
	g2.drawString("Draw a rectangle", 100,100);
	g2.drawRect(100,200,50,50);
    }
    
    public void saveImageToPNG(Canvas canvas){
        this.canvas = canvas;
        BufferedImage image = new BufferedImage(this.canvas.getWidth(), 
                this.canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 =(Graphics2D)image.getGraphics();
        
        //Graphics2D g2 =(Graphics2D)image.getGraphics();
        System.out.println("hola2");
	this.canvas.paint(g2);
        System.out.println("hola3");
	try {
            
            ImageIO.write(image, "png", new File("canvas.png"));
	} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
	}
    }
    
}
