
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
public class Character extends GameEntity implements IPrototype<Character>{
    

    private int life;
    private double hitsPerTime;
    private double fieldsInArmy;
    private int levelRequired;
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;
    private Direction direction;

    public Character() {
    }

    public Character(int life, double hitsPerTime, double fieldsInArmy, int levelRequired, 
            ArrayList<Weapon> weapons, Weapon currentWeapon, Direction direction, String name, 
            HashMap<Integer, ArrayList<String>> aspect, int level, double cost) {
        super(name, aspect, level, cost);
        this.life = life;
        this.hitsPerTime = hitsPerTime;
        this.fieldsInArmy = fieldsInArmy;
        this.levelRequired = levelRequired;
        this.weapons = weapons;
        this.currentWeapon = currentWeapon;
        this.direction = direction;
    }

    public Character(int life, double hitsPerTime, double fieldsInArmy, int levelRequired, 
            ArrayList<Weapon> weapons, Weapon currentWeapon, Direction direction) {
        this.life = life;
        this.hitsPerTime = hitsPerTime;
        this.fieldsInArmy = fieldsInArmy;
        this.levelRequired = levelRequired;
        this.weapons = weapons;
        this.currentWeapon = currentWeapon;
        this.direction = direction;
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

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    
    public void addWeapons(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Character clone() {
       HashMap<Integer,ArrayList<String>> aspect = this.aspect; 
       return new Character(life,hitsPerTime,fieldsInArmy,levelRequired,weapons,
               currentWeapon,direction,name, aspect,level,cost);
    }

    @Override
    public Character deepClone() {
        HashMap<Integer,ArrayList<String>> aspect = this.aspect; 
        ArrayList<Weapon> weaponsCloned = new ArrayList();
        this.weapons.stream().map((w) -> w.deepClone()).forEachOrdered((clon) -> {
            weaponsCloned.add(clon);
        });   
        return new Character(life,hitsPerTime,fieldsInArmy,levelRequired,weaponsCloned,
               currentWeapon,direction,name, aspect,level,cost);
    }

    @Override
    public void attack(GameEntity gameEntity) {
        System.out.println("Character Attacking xd");
    }



     public static class CharacterBuilder implements IBuilder<Character>{
        
        private String name;
        private HashMap<Integer,ArrayList<String>> aspect;
        private int life;
        private double hitsPerTime;
        private int level;
        private double fieldsInArmy;
        private int levelRequired;
        private int cost;
        private ArrayList<Weapon> weapons;
        private Weapon currentWeapon;
        private Direction direction;
        
        public CharacterBuilder() {
            this.aspect = new HashMap<>();
            currentWeapon = null;
            weapons = new ArrayList<>();
        }
   
        public CharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }
        
        public CharacterBuilder setAspect(HashMap<Integer,ArrayList<String>> aspect) {
            this.aspect = aspect;
            return this;
        }

        public CharacterBuilder addAspect(int level, ArrayList<String> aspectlevel) {
            this.aspect.put(level, aspectlevel);
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

        public CharacterBuilder setWeapons(ArrayList<Weapon> weapons) {
            this.weapons = weapons;
            return this;
        }

        public CharacterBuilder addWeapons(Weapon weapon) {
            //Instance 'cause weapon already has a builder
            weapons.add(weapon);
            return this;
        }
  
        public CharacterBuilder setCurrentWeapon(Weapon currentWeapon) {
            this.currentWeapon = currentWeapon;
            return this;
        }

        public CharacterBuilder setDirection(Direction direction) {
            this.direction = direction;
            return this;
        }
             
        
        @Override
        public Character build() {
            return new Character(this.life,this.hitsPerTime,this.fieldsInArmy,this.levelRequired,
                    this.weapons, this.currentWeapon, this.direction, this.name, this.aspect, 
                    this.level,this.cost);
        }

     }
}
