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
    
    private void createFolder(){
        File folder = new File(urlFolder);
        if (!folder.exists()) {
            System.out.println("El directorio no existe");
            folder.mkdir();
        }else{
            System.out.println("El directorio ya existe");
        }
    }
    
    private int getNewIdGraph(){
        File folder = new File(urlFolder);
        int newNumber = 0;
        if (folder.exists()) {
            File[] files = folder.listFiles();
            System.out.println("Lo que hay dentro del Folder es: ");
            System.out.print("[ ");
            for (File file : files) {
                System.out.print(file.getName() + " | ");
            }
            System.out.print(" ]");
            /*If exist files inside the folder*/
            if (files.length>0) {
                for (File file : files) {
                    String nameWithFormat = file.getName();
                    /*Este if es para saltarse el archivo Thumbs.db*/
                    if (!nameWithFormat.equals("Thumbs.db")) {
                        String nameWithoutFormat = nameWithFormat.replaceAll(".png", "");
                        String numero = nameWithoutFormat.substring(5);
                        int lastNumber = Integer.parseInt(numero);
                        lastNumber++;
                        newNumber = lastNumber;
                        System.out.println("Último número: " + newNumber);
                    }
                }
            }
        }
        return newNumber;
    }
    
    public boolean saveImageToPNG(Canvas canvas){
        createFolder();
        boolean saveSucces = false;
        BufferedImage image = new BufferedImage(canvas.getWidth(), 
                canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 =(Graphics2D)image.getGraphics();
        
        //Graphics2D g2 =(Graphics2D)image.getGraphics();
	canvas.paint(g2);
	try {
            int idGraphImage = getNewIdGraph();
            String url = urlFolder+"\\Grafo"+idGraphImage+".png";
            System.out.println("URL: " + url);
            ImageIO.write(image, "png", new File(urlFolder + "\\Grafo" + idGraphImage + ".png"));
            saveSucces = true;
	} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
	}
        return saveSucces;
    }
    
    private static String urlFolder = "Imágenes";
    
}
