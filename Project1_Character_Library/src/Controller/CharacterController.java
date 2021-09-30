/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Character;
import Model.CharacterPrototypeFactory;
import Model.Direction;
import Model.ICreator;
import Model.Weapon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import utils.JSONLoader;

/**
 *
 * @author aguil
 */
public class CharacterController {
    
    private final JSONLoader json;
    private ICreator factory;
    
    public CharacterController() throws IOException{
        this.json = JSONLoader.getInstance();
        this.factory = new CharacterPrototypeFactory();
        if(!json.getCharacters().isEmpty()){
            this.loadCharacters();
        }
    }
    
    private void loadCharacters(){
        json.getCharacters().forEach(it -> {
            this.factory.addPrototype(it.getName(), it);
        });
    }
    
    public void createCharacter(String pName, int pLife, int pLevelReq,
                                int pLevel, int pHitsPerTime, int pFields,
                                Direction pDirection, ArrayList<Weapon> pWeapons,
                                Weapon pCurrent, int pCost, HashMap<Integer, 
                                ArrayList<String>> pAspects) throws IOException{
        Character character = new Character.CharacterBuilder()
                .setName(pName)
                .setLife(pLife)
                .setLevelRequired(pLevelReq)
                .setLevel(pLevel)
                .setHitsPerTime(pHitsPerTime)
                .setFieldsInArmy(pFields)
                .setDirection(pDirection)
                .setWeapons(pWeapons)
                .setCurrentWeapon(pCurrent)
                .setCost(pCost)
                .setAspect(pAspects)
                .build();
        this.factory.addPrototype(pName, character);
        this.json.writeJSON(character);
    }
    
    public ArrayList<Character> getManyCharacters(String pName, int pQuantity){
        ArrayList<Character> list = new ArrayList<>();
        for(int index = 0; index < pQuantity; index++){
            list.add((Character)this.factory.getPrototypeDeepClone(pName));
        }
        return list;
    }
    
    public Character getCharacter(String pName){
        return (Character)this.factory.getPrototypeDeepClone(pName);
    }
}
