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
public class Weapon extends GameEntity implements IPrototype<Weapon>{

    private int scope;
    private double damage;
    private double explotionRange;
    private boolean levelIncrease;

    public Weapon() {}

    public Weapon(int scope, double damage, double explotionRange, boolean levelIncrease, String name, HashMap<Integer, ArrayList<String>> aspect, int level, double cost) {
        super(name, aspect, level, cost);
        this.scope = scope;
        this.damage = damage;
        this.explotionRange = explotionRange;
        this.levelIncrease = levelIncrease;
    }

    public Weapon(int scope, double damage, double explotionRange, boolean levelIncrease) {
        this.scope = scope;
        this.damage = damage;
        this.explotionRange = explotionRange;
        this.levelIncrease = levelIncrease;
    }


    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

   
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getExplotionRange() {
        return explotionRange;
    }

    public void setExplotionRange(double explotionRange) {
        this.explotionRange = explotionRange;
    }

    public boolean isLevelIncrease() {
        return levelIncrease;
    }

    public void setLevelIncrease(boolean levelIncrease) {
        this.levelIncrease = levelIncrease;
    }
    

    @Override
    public Weapon clone() {
        HashMap<Integer,ArrayList<String>> aspect = this.aspect; 
        return new Weapon( this.scope, this.damage, this.explotionRange,
                    this.levelIncrease,this.name, this.aspect, this.level,this.cost); 
    }

    @Override
    public Weapon deepClone() {
        return clone();
    }

    @Override
    public void attack(GameEntity gameEntity) {
        System.out.println("Weapon Attacking xd");
    }
    
    
    public static class WeaponBuilder implements IBuilder<Weapon>{
        
        private String name;
        private int scope;
        private HashMap<Integer,ArrayList<String>> aspect = new HashMap<>();
        private double damage;
        private double explotionRange;
        private int level;
        private boolean levelIncrease;
        private double cost;
        
        public WeaponBuilder(){}

        public WeaponBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public WeaponBuilder setScope(int scope) {
            this.scope = scope;
            return this;
        }

        public WeaponBuilder addAspect(int level, ArrayList<String> aspectlevel) {
            this.aspect.put(level, aspectlevel);
            return this;
        }
        
        public WeaponBuilder setAspect(HashMap<Integer,ArrayList<String>> aspect) {
            this.aspect = aspect;
            return this;
        }


        public WeaponBuilder setDamage(double damage) {
            this.damage = damage;
            return this;
        }

        public WeaponBuilder setExplotionRange(double explotionRange) {
            this.explotionRange = explotionRange;
            return this;
        }

        public WeaponBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public WeaponBuilder setLevelIncrease(boolean levelIncrease) {
            this.levelIncrease = levelIncrease;
            return this;
        }

        public WeaponBuilder setCost(double cost) {
            this.cost = cost;
            return this;
        }
        
        
        
        @Override
        public Weapon build() {
            return new Weapon( this.scope, this.damage, this.explotionRange,
                    this.levelIncrease,this.name, this.aspect, this.level,this.cost);
        
        
        }
    }
}
