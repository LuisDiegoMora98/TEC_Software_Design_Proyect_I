/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Natalia
 */
public class CharacterController {
 
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
}
