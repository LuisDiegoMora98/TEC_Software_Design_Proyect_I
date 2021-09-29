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
import utils.JSONLoader;

/**
 *
 * @author aguil
 */
public class CharacterController {
    
    private final JSONLoader json;
    
    public CharacterController() throws IOException{
        this.json = JSONLoader.getInstance();
        
    }
    
    public void createCharacter() throws IOException{
        Weapon weapon = new Weapon(1, 500, 25, true);
        ArrayList<Weapon> weaponList = new ArrayList<>();
        weaponList.add(weapon);
        Model.Character charac = new Model.Character(100, 5, 2, 2, weaponList, weapon, Direction.WEST);
        System.out.println("\n\nWriting JSON...\n");
        this.json.writeJSON(charac);
    }
    
    public static void main(String[] args) throws IOException {
        CharacterController test = new CharacterController();
        test.createCharacter();
    }
    
}
