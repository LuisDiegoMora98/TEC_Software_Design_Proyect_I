/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author LDAZ
 */

import Model.IPrototype;
import Model.WeaponPrototypeFactory;
import java.util.ArrayList;
import Model.Weapon;

public class WeaponController {
    
    public Weapon getWeapon(String name){
        return (Weapon)WeaponPrototypeFactory.getPrototype(name);
    }
    
    public ArrayList<Weapon> getManyWeapons(String name, int quantity){
        ArrayList<Weapon> weapons = new ArrayList<Weapon>(); 
        for(int i = 0; i< quantity; i++){
             weapons.add((Weapon)WeaponPrototypeFactory.getPrototype(name));
        }
        return weapons;
    }
    
    public void loadWapons(){
        
    }
    
    public void saveWeapon(Weapon weapon, String name){
        WeaponPrototypeFactory.addPrototype(name, weapon);
    }
    
}
