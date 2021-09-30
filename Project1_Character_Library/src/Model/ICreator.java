/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Natalia
 */
public abstract class ICreator {
    protected HashMap<String,IPrototype> prototypes = new HashMap<>();       
    
    public ICreator(){
        this.prototypes = new HashMap<>();
    }
    
    public IPrototype getPrototypeDeepClone(String prototypeName){    
            return prototypes.get(prototypeName).deepClone();
    }  
    
    public IPrototype getPrototypeClone(String prototypeName){
        return prototypes.get(prototypeName).clone();
    }  
    
    public void addPrototype(String prototypeName,IPrototype prototype){   
        prototypes.put(prototypeName, prototype);   
    }
    
    public HashMap<String,IPrototype> getPrototypes(){
        return this.prototypes;
    }
}
