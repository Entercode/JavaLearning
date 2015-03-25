/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

import com.github.entercode.area.Area;
import com.github.entercode.area.DebugArea;
import com.github.entercode.entity.Entity;
import com.github.entercode.tile.AirTile;
import com.github.entercode.tile.DirtTile;
import com.github.entercode.tile.IronFenceTile;
import com.github.entercode.tile.NullTile;
import com.github.entercode.tile.OreTile;
import com.github.entercode.tile.StoneTile;
import com.github.entercode.tile.Tile;
import com.github.entercode.util.Log;
import java.util.ArrayList;

/**
 *
 * @author entercode
 */
public class GameRegister {
	
	// Entity Register
	public static ArrayList<Entity> EntityRegister = new ArrayList<>(1024);
	public static ArrayList<Tile> TileRegister = new ArrayList<>(4096);
	
	// Render Register
	public static Area currentArea;
	
	public static void init() {
		
		Log.info("array...", "init");
		
		for(int i = 0; i < 1024; i++) {
			EntityRegister.add(null);
		}
		
		for(int i = 0; i < 4096; i++) {
			TileRegister.add(null);
		}
		
		Log.info(TileRegister.size());
	}

	
	public static void load() {
		
		init();
		
		loadArea();
		loadEntity();
		loadTile();
		
		currentArea = new DebugArea();
	}
	
	public static void loadEntity() {
		Log.info("load Entity");
		
	}
	
	public static void loadTile() {
		
		register(0,		new NullTile		(0, "Null"));
		register(7,	new AirTile			(7, "Air"));
		register(8,	new DirtTile		(8, "Dirt"));
		register(9,		new IronFenceTile	(9, "IronFence"));
		register(11,		new OreTile			(11, "Ore"));
		register(14,	new StoneTile		(14, "Stone"));
		register(13,		new StoneTile			(13, "Stone"));
		
		Log.info("loaded Tile");
		System.out.printf("%d", TileRegister.size());
		
	}
	
	public static void loadArea() {
		Log.info("load Area");
	}

	public static void register(int id, Entity par0) {
		EntityRegister.set(id, par0);
	}

	public static void register(int id, Tile par0) {
		TileRegister.set(id, par0);
	}
}
