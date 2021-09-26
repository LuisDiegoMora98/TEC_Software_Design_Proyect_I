/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Natalia
 */
public abstract class ICreator {
    
    static HashMap<String,IPrototype> prototypes = new HashMap<>();       
    static ArrayList<IPrototype> clones = new ArrayList<>();
    
    public static  ArrayList<IPrototype> getPrototypeDeepClone(String prototypeName, int quantity){    
        for (int i=0; i< quantity; i++){
             clones.add(prototypes.get(prototypeName).deepClone());
        }
        return clones;         
    }  
    
    public static  ArrayList<IPrototype> getPrototypeClone(String prototypeName, int quantity){    
        for (int i=0; i< quantity; i++){
             clones.add(prototypes.get(prototypeName).clone());
        }
        return clones;         
    }  
    
    public static void addPrototype(String prototypeName,IPrototype prototype){   
        prototypes.put(prototypeName, prototype);   
    }
}
