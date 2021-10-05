/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GeneralViwer;
import java.util.ArrayList;
import Model.Character;
import Model.Weapon;
import View.WeaponForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LDAZ
 */
public class GeneralViewerController {
    

    private static GeneralViewerController controllerViewer;
    private CharacterController characters;
    private WeaponController weapons;
    private GeneralViwer viewer;
    
    private GeneralViewerController() {
        try {
            characters = CharacterController.getInstance();
            weapons = WeaponController.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(GeneralViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static GeneralViewerController getInstance(){
        if(controllerViewer == null){
            controllerViewer = new GeneralViewerController();
        }
        return controllerViewer;
    }    
    
    
    public void init(){
        viewer = new GeneralViwer();
        viewer.setVisible(true);
    }
    public ArrayList<Character> getCharacterList(){
        return characters.getAllCharacters();
    }
    
    public ArrayList<Weapon> getWeaponList(){
        return weapons.getAllWeapons();
    }
    
    public void refresh(){
    
    }
}
