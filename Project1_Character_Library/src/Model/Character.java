
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
public class Character implements IPrototype<Gun>{
    
    private String name;
    private HashMap<Integer,Image> aspect;
    private int life;
    private double hitsPerTime;
    private int level;
    private double fieldsInArmy;
    private int levelRequired;
    private int cost;

    public Character(String name, HashMap<Integer, Image> aspect, int life, double hitsPerTime, int level, double fieldsInArmy, int levelRequired, int cost) {
        this.name = name;
        this.aspect = aspect;
        this.life = life;
        this.hitsPerTime = hitsPerTime;
        this.level = level;
        this.fieldsInArmy = fieldsInArmy;
        this.levelRequired = levelRequired;
        this.cost = cost;
    }

    public Character() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Image> getAspect() {
        return aspect;
    }

    public void setAspect(HashMap<Integer, Image> aspect) {
        this.aspect = aspect;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public double getHitsPerTime() {
        return hitsPerTime;
    }

    public void setHitsPerTime(double hitsPerTime) {
        this.hitsPerTime = hitsPerTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getFieldsInArmy() {
        return fieldsInArmy;
    }

    public void setFieldsInArmy(double fieldsInArmy) {
        this.fieldsInArmy = fieldsInArmy;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(int levelRequired) {
        this.levelRequired = levelRequired;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
    @Override
    public Gun clone() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Gun deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
     public static class CharacterBuilder implements IBuilder<Character>{
        
        private String name;
        private HashMap<Integer,Image> aspect;
        private int life;
        private double hitsPerTime;
        private int level;
        private double fieldsInArmy;
        private int levelRequired;
        private int cost;
   
        public CharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CharacterBuilder setAspect(int level) {
            this.aspect.put(level, null);
            return this;
        }

        public CharacterBuilder setLife(int life) {
            this.life = life;
            return this;
        }

        public CharacterBuilder setHitsPerTime(double hitsPerTime) {
            this.hitsPerTime = hitsPerTime;
            return this;
        }

        public CharacterBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public CharacterBuilder setFieldsInArmy(double fieldsInArmy) {
            this.fieldsInArmy = fieldsInArmy;
            return this;
        }

        public CharacterBuilder setLevelRequired(int levelRequired) {
            this.levelRequired = levelRequired;
            return this;
        }

        public CharacterBuilder setCost(int cost) {
            this.cost = cost;
            return this;
        }
             
        
        @Override
        public Character build() {
            return new Character(this.name, this.aspect, this.life, this.hitsPerTime, this.level, this.fieldsInArmy, this.levelRequired, this.cost);
        }

     }
}
