/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

import com.github.entercode.entity.Entity;
import com.github.entercode.entity.player.Player;
import com.github.entercode.tile.Tile;
import com.github.entercode.util.Log;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author entercode
 */
public class GameRegister {
	
	// Entity Register
	public static ArrayList<Entity> EntityRegister = new ArrayList<>();
	public static ArrayList<Tile> TileRegister = new ArrayList<>();
	
	// Render Register


	
	public static void load() {
		
		loadMap();
		loadEntity();
		
	}
	
	public static void loadEntity() {
		Log.info("load Entity");
		
		register((Entity)(new Player(0, "Player", 20, new Point(), 16, 24, 16, 24, "resource/texture/entity/player/test.png")));
		
	}
	
	public static void loadMap() {
		Log.info("load Map");
		
	}

	public static void register(Entity par0) {
		EntityRegister.add(par0);
	}

	public static void register(Tile par0) {
		TileRegister.add(par0);
	}
}
