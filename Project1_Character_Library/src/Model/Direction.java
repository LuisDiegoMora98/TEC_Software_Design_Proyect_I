/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Natalia
 */
public enum Direction {

    EAST(1, 0),
    WEST(-1, 0),
    SOUTH(0, -1),
    NORTH(0, 1),
    SOUTHEAST(1, 1),
    SOUTHWEST(-1, 1),
    NORTHEAST(1, -1),
    NORTHWEAST(-1, 1),;
    

    private  int x;  
    private  int y;
    
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
  
}
