/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Natalia
 */
public abstract class GameEntity implements Serializable {
    
    protected String name;
    protected HashMap<Integer,ArrayList<String>> aspect;
    protected int level;
    protected double cost;
  

    public GameEntity(String name, HashMap<Integer,ArrayList<String>> aspect, 
            int level, double cost) {
        this.name = name;
        this.aspect = aspect;
        this.level = level;
        this.cost = cost;
    }

    public GameEntity() {
        this.aspect = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer,ArrayList<String>> getAspect() {
        return aspect;
    }

    public void setAspect(HashMap<Integer,ArrayList<String>> aspect) {
        this.aspect = aspect;
    }
    
    public void addAspect(int level, ArrayList<String> aspectLevel) {
        this.aspect.put(level, aspectLevel);
    } 

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        this.level += 1;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
  
}
