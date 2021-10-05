/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Direction;
import Model.Weapon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lalem
 */
public class Main {
    
    public static void main (String [] args){
        /* CharacterController characters = null;
         WeaponController weapons = null;
        try {
            characters = CharacterController.getInstance();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        
        try {
            weapons = WeaponController.getInstance();
        } catch (Exception e) { 
            System.out.println(e.getCause());
        }
        
        // PRUEBAS, SE PUEDE BORRAR EN CUALQUIER MOMENTO
        
        HashMap<Integer, ArrayList<String>> weaponsAspect = new HashMap<>(); 
        ArrayList skins = new ArrayList<String>();
        skins.add("Skin 1");
        weaponsAspect.put(1, skins);
        skins.set(0, "skin 2");
        weaponsAspect.put(1, skins);
        skins.set(0, "skin 3");
        weaponsAspect.put(1, skins);
        skins.set(0, "skin 4");
        weaponsAspect.put(1, skins);
          try {
            weapons.createWeapon(10, 6, 9, true, "Espada de madera", 9, 7);
            weapons.createWeapon(10, 6, 10 , true, "Espada de Hierro", 10, 9);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Weapon> w = weapons.getManyWeapons("Espada de madera", 2);
        try {
            characters.createCharacter("Enderman", 5, 12, 5, 4, 4, Direction.WEST, w, w.get(0), 0, weaponsAspect);
            characters.createCharacter("Creeper", 2, 25, 10, 7, 9, Direction.WEST, w, w.get(0), 0, weaponsAspect);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        GeneralViewerController.getInstance().init();
    }
    
}
