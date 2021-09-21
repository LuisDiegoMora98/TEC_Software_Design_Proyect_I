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
public class Gun implements IPrototype<Gun>{
    private String name;
    private int scope;
    private HashMap<Integer,Image> aspect;  // No sé si este image mejor es un path
    private double damage;
    private double explotionRange;
    private int level;
    private boolean levelIncrease;

    public Gun() {
        this.aspect = new HashMap<>();
    }

    public Gun(String name, int scope, HashMap<Integer, Image> aspect, double damage, double explotionRange, int level, boolean levelIncrease) {
        this.name = name;
        this.scope = scope;
        this.aspect = aspect;
        this.damage = damage;
        this.explotionRange = explotionRange;
        this.level = level;
        this.levelIncrease = levelIncrease;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public HashMap<Integer, Image> getAspect() {
        return aspect;
    }

    public void setAspect(HashMap<Integer, Image> aspect) {
        this.aspect = aspect;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLevelIncrease() {
        return levelIncrease;
    }

    public void setLevelIncrease(boolean levelIncrease) {
        this.levelIncrease = levelIncrease;
    }
    

    @Override
    public Gun clone() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Gun deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    public static class GunBuilder implements IBuilder<Gun>{
        
        private String name;
        private int scope;
        private HashMap<Integer,Image> aspect;  // No sé si este image mejor es un path
        private double damage;
        private double explotionRange;
        private int level;
        private boolean levelIncrease;

        public GunBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GunBuilder setScope(int scope) {
            this.scope = scope;
            return this;
        }

        public GunBuilder setAspect(int level) {
            // parametro para la imagen
            this.aspect.put(level, null);
            return this;
        }

        public GunBuilder setDamage(double damage) {
            this.damage = damage;
            return this;
        }

        public GunBuilder setExplotionRange(double explotionRange) {
            this.explotionRange = explotionRange;
            return this;
        }

        public GunBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public GunBuilder setLevelIncrease(boolean levelIncrease) {
            this.levelIncrease = levelIncrease;
            return this;
        }
        
        @Override
        public Gun build() {
            return new Gun(this.name, this.scope, this.aspect, this.damage, this.explotionRange, this.level, this.levelIncrease);
        }
    }
}
