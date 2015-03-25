/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.area;

import com.github.entercode.entity.*;
import com.github.entercode.tile.*;
import com.github.entercode.util.Log;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author entercode
 */
public abstract class Area {
	
	protected int		id;
	protected String	name		= "NA-Area";
	protected int		width		= 4;
	protected int		height		= 3;
	public Image		texture;
	public BufferedImage backTile;
	public BufferedImage frontTile;

	public ArrayList<Entity> entityRegister = new ArrayList<>();
	public ArrayList<Tile> backTileRegister = new ArrayList<>();
	public ArrayList<Tile> frontTileRegister = new ArrayList<>();
	
	public Area(int id, String name, int width, int height) {
		
		init(id, name, width, height);
	}
	
	private void init(int id, String name, int width, int height) {
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.backTile = new BufferedImage(width * 32, height * 32, BufferedImage.TYPE_INT_ARGB);
		this.frontTile = new BufferedImage(width * 32, height * 32, BufferedImage.TYPE_INT_ARGB);
		
		load();
	}
	
	public void draw(Graphics2D g2d) {
		// Background Image
		g2d.drawImage(texture, 0, 0, null);
		
		// Back Tile
		g2d.drawImage(backTile, null, 0, 0);
		
		// Front Tile
		g2d.drawImage(frontTile, null, 0, 0);
		
	}
	
	public abstract void update();
	
	
	
	private void load() {
		loadBackground();
		loadBackTile();
		loadFrontTile();
	}
		
	private void loadBackTile() {
		
		Graphics2D g2d = backTile.createGraphics();
		
		// Tile
		int row, col;
		int cnt = 0;
		for(Tile t : backTileRegister) {
			col = cnt % this.width;
			row = cnt / this.width;
			t.draw(g2d, col, row, 0, 0);
			cnt++;
		}
	}
	
	private void loadFrontTile() {
		
		Graphics2D g2d = frontTile.createGraphics();
		
		// Tile
		int row, col;
		int cnt = 0;
		for(Tile t : frontTileRegister) {
			col = cnt % this.width;
			row = cnt / this.width;
			t.draw(g2d, col, row, 0, 0);
			cnt++;
		}
		
		
	}	
		
	private void loadBackground() {
		
		try {
			texture = ImageIO.read(new File("res/texture/area/" + name.toLowerCase() + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		// debug
		backTileRegister.add(new AirTile(0));
		backTileRegister.add(new AirTile(0));
		backTileRegister.add(new AirTile(0));
		backTileRegister.add(new OreTile(0));
		backTileRegister.add(new AirTile(0));
		backTileRegister.add(new AirTile(0));
		backTileRegister.add(new OreTile(0));
		backTileRegister.add(new OreTile(0));
		backTileRegister.add(new DirtTile(0));
		backTileRegister.add(new DirtTile(0));
		backTileRegister.add(new DirtTile(0));
		backTileRegister.add(new DirtTile(0));
		
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new IronFenceTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new IronFenceTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
		frontTileRegister.add(new NullTile(0));
	}
	
	
	
	
}
