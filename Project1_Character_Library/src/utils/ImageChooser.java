/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Natalia
 */
public class ImageChooser {
    
    private static JFileChooser chooser = new JFileChooser();
    
    /**
     * Choose a file and returns the string path 
     * @return String path
     * @throws IOException 
     */
    public static ArrayList<String> Choose() throws IOException{

        ArrayList<String> paths = new ArrayList<>();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        Component parent = null; //to safe the selected directory
        chooser.setMultiSelectionEnabled(true);  //Allow multiple selection
        FileFilter filter = new FileNameExtensionFilter ("Archivo de imagen", "JPG", "JPEG", "GIF", "PNG"); 
        //Filter to choose only images
	chooser.setFileFilter(filter);
        
        int returnVal = chooser.showSaveDialog(parent);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {

           File[] files = chooser.getSelectedFiles();
            for (File file : files) {
                paths.add(file.getAbsolutePath());
            }

         }
        
        return paths;
    }
    
    public static Image getImage(int X,int Y,String pathname) throws IOException{
        File file = new File(pathname);
        BufferedImage image = ImageIO.read(file);
        Image resized = image.getScaledInstance(X, Y, Image.SCALE_SMOOTH);
        return resized;
    }
    
    
}
