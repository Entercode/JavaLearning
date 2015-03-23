/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

import com.github.entercode.entity.Entity;
import com.github.entercode.tile.Tile;
import java.util.ArrayList;

/**
 *
 * @author entercode
 */
public class GameRegister {
    public static ArrayList<Entity> EntityRegister = new ArrayList<Entity>();
    public static ArrayList<Tile> TileRegister = new ArrayList<Tile>();
    
    public GameRegister() {
        
        
    }
    
    public void register(Entity par0) {
        EntityRegister.add(par0);
    }
    
    public void register(Tile par0) {
        TileRegister.add(par0);
    }
}
