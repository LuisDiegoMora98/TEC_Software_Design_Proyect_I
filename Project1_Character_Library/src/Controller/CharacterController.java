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
import Model.IPrototype;
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
    private HashMap<Integer, ArrayList<String>> aspects;
    private ArrayList<Weapon> weapons;
    private static CharacterController controller;
    
    private CharacterController() throws IOException{
        this.json = JSONLoader.getInstance();
        this.factory = new CharacterPrototypeFactory();
        this.aspects = new HashMap<>();
        this.weapons = new ArrayList<>();
        if(!json.getCharacters().isEmpty()){
            this.loadCharacters();
        }
    }
    
    public synchronized static CharacterController getInstance() throws IOException{
        if(CharacterController.controller != null){
            return controller;
        }
        CharacterController.controller = new CharacterController();
        return controller;
    }
    
    private void loadCharacters(){
        json.getCharacters().forEach(it -> {
            this.factory.addPrototype(it.getName(), it);
        });
    }
    
    public Character createCharacter(String pName, int pLife, int pLevelReq,
                                int pLevel, double pHitsPerTime, double pFields,
                                Direction pDirection,double pCost) throws IOException{
        Character character = new Character.CharacterBuilder()
                .setName(pName)
                .setLife(pLife)
                .setLevelRequired(pLevelReq)
                .setLevel(pLevel)
                .setHitsPerTime(pHitsPerTime)
                .setFieldsInArmy(pFields)
                .setDirection(pDirection)
                .setWeapons(this.weapons)
                .setCost(pCost)
                .setAspect(this.aspects)
                .build();
        this.factory.addPrototype(pName, character);
        this.json.writeJSON(character);
        aspects.clear();
        weapons.clear();
        return character;
        
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
    
    public ArrayList<Character> getAllCharacters(){
        ArrayList<IPrototype> list = new ArrayList<>((
                (CharacterPrototypeFactory)this.factory)
                .getPrototypes().values());
        ArrayList<Character> finalList = new ArrayList<>();
        list.forEach(it -> {
            finalList.add((Character)it);
        });
        return finalList;
    }
    
    public ArrayList<Weapon> getWeapons(Character character){
        return character.getWeapons();
    }
            
    public void insertCharacterLevel(int level, ArrayList<String> images){
        this.aspects.put(level, images);
    }
    
    public void insertWeapons(Weapon weapon){
        this.weapons.add(weapon);
    }
}
