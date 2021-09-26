/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.util.HashMap;

/**
 *
 * @author Natalia
 */
public class WeaponController {
 
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
