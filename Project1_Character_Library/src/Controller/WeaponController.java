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
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import utils.JSONLoader;

public class WeaponController {
    
    private final JSONLoader json;
    
    public WeaponController() throws IOException{
    
        this.json = JSONLoader.getInstance();
    }
    
    public Weapon getWeapon(String name){
        return (Weapon)WeaponPrototypeFactory.getPrototypeDeepClone(name,1)
                .get(0);
    }
    
    public ArrayList<Weapon> getManyWeapons(String name, int quantity){
        ArrayList<Weapon> weapons = new ArrayList<Weapon>(); 
        for(int i = 0; i< quantity; i++){
             weapons.add((Weapon)WeaponPrototypeFactory.getPrototype(name));
        }
        return weapons;
    }
    
    public void loadWapons(){
       json.r
    }
    
    public Weapon crateWeapon(int scope, double damage, double explotionRange, 
        boolean levelIncrease,String name, HashMap<Integer, Image> aspect, 
        int level, double cost) throws IOException{

        //No se le está pasando el aspect, pero en realidad puede ser una lista de images
        //y otra de cant de niveles, o un array de array si es posible
        Weapon weapon = new Weapon.WeaponBuilder().setName(name)
                .setScope(scope)
                //.addAspect(aspect)
                .setDamage(damage)
                .setExplotionRange(explotionRange)
                .setLevel(level)
                .setLevelIncrease(levelIncrease)
                .setCost(cost)
                .build();
        
        WeaponPrototypeFactory.addPrototype(name, weapon);
        json.writeJSON(weapon);
        return weapon;
    }
    
}
