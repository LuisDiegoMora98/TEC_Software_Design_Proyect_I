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
    
    protected HashMap<String,IPrototype> prototypes = new HashMap<>();       
    protected ArrayList<IPrototype> clones = new ArrayList<>();
    
    public ICreator(){
        this.clones = new ArrayList<>();
        this.prototypes = new HashMap<>();
    }
    
    public ArrayList<IPrototype> getPrototypeDeepClone(String prototypeName, int quantity){    
        this.clones = new ArrayList<>();
        for (int i=0; i< quantity; i++){
             clones.add(prototypes.get(prototypeName).deepClone());
        }
        return clones;         
    }  
    
    public ArrayList<IPrototype> getPrototypeClone(String prototypeName, int quantity){
        this.clones = new ArrayList<>();
        for (int i=0; i< quantity; i++){
             clones.add(prototypes.get(prototypeName).clone());
        }
        return clones;         
    }  
    
    public void addPrototype(String prototypeName,IPrototype prototype){   
        prototypes.put(prototypeName, prototype);   
    }
}
