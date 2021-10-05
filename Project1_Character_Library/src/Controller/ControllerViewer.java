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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lalem
 */
public class ControllerViewer {
    

    private static ControllerViewer controllerViewer;
    private CharacterController characters;
    private WeaponController weapons;
    private GeneralViwer viewer;
    
    private ControllerViewer() {
        try {
            characters = CharacterController.getInstance();
            weapons = WeaponController.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(ControllerViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ControllerViewer getInstance(){
        if(controllerViewer == null){
            controllerViewer = new ControllerViewer();
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
    
    public void newCharacter(){
        //Agregar el controlador del character Form
       
    }
    
    public void newWeapon(){
        //Agregar el controlador del weapon Form
       
    }
    
    public void editCharacter(Character character){
        //Agregar el controlador del character Form
       
    }
    
    public void editWeapon(Weapon weapon){
        //Agregar el controlador del character Form
       
    }
    
    
    public void refresh(){
    
    }
}
