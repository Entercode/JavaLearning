/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.tile;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author entercode
 */
public abstract class Tile {
	
	protected int		id;
	protected String	name	= "NA-Tile";
	protected Image		texture;
	
	public Tile(int id, String name) {
		init(id, name);
	}
	
	private void init(int id, String name) {
		this.id = id;
		this.name = name;
		
		loadImage();
	}
	
	public void draw(Graphics2D g2d, int x, int y, int ox, int oy) {
		g2d.drawImage(texture, 32 * x + ox, 32 * y + oy, null);
		System.out.printf("[xy] %2d, %2d\n", 32 * x + ox, 32 * y + oy);
	}
	
	public abstract void update();
	
	private void loadImage() {
		try {
			texture = ImageIO.read(new File("res/texture/tile/" + name.toLowerCase() + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}