/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author crhistian
 */
public class Exporter extends Canvas{
    
    public Exporter() {
        
    }
    
    public boolean saveImageToPNG(Canvas canvas){
        boolean saveSucces = false;
        BufferedImage image = new BufferedImage(canvas.getWidth(), 
                canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 =(Graphics2D)image.getGraphics();
        
        //Graphics2D g2 =(Graphics2D)image.getGraphics();
        System.out.println("hola2");
	canvas.paint(g2);
        System.out.println("hola3");
	try {
            ImageIO.write(image, "png", new File("canvas.png"));
            saveSucces = true;
	} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
	}
        return saveSucces;
    }
    
}
