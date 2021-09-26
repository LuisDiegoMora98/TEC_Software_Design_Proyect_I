/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Direction;
import Model.IPrototype;
import Model.JSONLoader;
import Model.Weapon;
import Model.Character;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Natalia 
 */
public class PrototypeFillerController {
    private JSONLoader jsonLoader;
    
    public void createCharacterPrototype(int life, double hitsPerTime, double fieldsInArmy, 
            int levelRequired, ArrayList<IPrototype> weapons, Weapon currentWeapon, Direction direction, 
            String name, HashMap<Integer, Image> aspect, int level, double cost){
            Character character = new Character.CharacterBuilder().setName(name)
                    // .addAspect(x,y,z)
                    .setLife(life)
                    .setHitsPerTime(hitsPerTime)
                    .setLevel(level)
                    .setFieldsInArmy(fieldsInArmy)
                    .setLevelRequired(levelRequired)
                    .setCost(life)
                    //.setWeapons((Weapon) weapons)
                    .setCurrentWeapon(currentWeapon)
                    .setDirection(direction)
                    .build();
            
    }
    
    public Weapon createWeaponPrototype(int scope, double damage, double explotionRange, 
            boolean levelIncrease,String name, HashMap<Integer, Image> aspect, 
            int level, double cost){
        
            //No se le está pasando el aspect, pero en realidad puede ser una lista de images
            //y otra de cant de niveles, o un array de array si es posible
            Weapon weapon = new Weapon.WeaponBuilder().setName(name)
                    .setScope(scope)
                    // .addAspect(x,y,z)
                    .setDamage(damage)
                    .setExplotionRange(explotionRange)
                    .setLevel(level)
                    .setLevelIncrease(levelIncrease)
                    .setCost(cost)
                    .build();
            return weapon;
    }
}
