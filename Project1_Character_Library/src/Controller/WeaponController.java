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

import Model.WeaponPrototypeFactory;
import java.util.ArrayList;
import Model.Weapon;
import java.io.IOException;
import java.util.HashMap;
import utils.JSONLoader;

public class WeaponController {
    
    private final JSONLoader json;
    private WeaponPrototypeFactory weaponPrototypes;
    private HashMap<Integer, ArrayList<String>> aspects;
    
    public WeaponController() throws IOException{
        this.json = JSONLoader.getInstance();
        this.weaponPrototypes = new  WeaponPrototypeFactory();
        this.aspects = new HashMap<>();
        loadWeapons();
    }
    
    public Weapon getWeapon(String name){
        return (Weapon)weaponPrototypes.getPrototypeDeepClone(name);
    }
    
    public ArrayList<Weapon> getManyWeapons(String name, int quantity){
         ArrayList<Weapon> weapons = new ArrayList<Weapon>(); 
        for(int i = 0; i< quantity; i++){
             weapons.add((Weapon)weaponPrototypes.getPrototypeDeepClone(name));
        }
        return weapons;
    }
    
    
    public Weapon createWeapon(int scope, double damage, double explotionRange, 
        boolean levelIncrease,String name,int level, double cost) throws IOException{
        // HashMap<Integer, ArrayList<String>> aspect

        Weapon weapon = new Weapon.WeaponBuilder().setName(name)
                .setScope(scope)
                .setAspect(this.aspects)
                .setDamage(damage)
                .setExplotionRange(explotionRange)
                .setLevel(level)
                .setLevelIncrease(levelIncrease)
                .setCost(cost)
                .build();
        
        aspects.clear();  
        weaponPrototypes.addPrototype(name, weapon);
        json.writeJSON(weapon);
        return weapon;
    }
    
    public void insertWeaponLevel(int level, ArrayList<String> images){
        aspects.put(level, images);
    }
    
    private void loadWeapons(){
        ArrayList<Weapon> weapons = json.getWeapons();
        weapons.forEach(weapon -> {
            weaponPrototypes.addPrototype(weapon.getName(), weapon);
        });
    }
    
}
