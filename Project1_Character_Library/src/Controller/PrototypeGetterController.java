/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CharacterPrototypeFactory;
import Model.GameObjectsEnum;
import Model.IPrototype;
import Model.WeaponPrototypeFactory;
import java.util.ArrayList;

/**
 *
 * @author Natalia
 */
public class PrototypeGetterController {
    
    private ArrayList<IPrototype> clones;
    
    public ArrayList<IPrototype> getPrototype(String name, GameObjectsEnum type, int quantity){
        
        switch(type){
            case CHARACTER:
               for (int i=0; i< quantity; i++){
                   clones.add(CharacterPrototypeFactory.getPrototype(name));
               }  
               return clones;
            case WEAPON:
                for (int i=0; i< quantity; i++){
                   clones.add(WeaponPrototypeFactory.getPrototype(name));
               }
               return clones;
            default:
                return null;  //Manejo de errores?
        }
        
    }
}
