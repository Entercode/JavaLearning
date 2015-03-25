/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.entity;

import com.github.entercode.util.Log;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author entercode
 */
public abstract class Entity {
	
	public int		id;			// entity id
	public String	name;		// entity name(using in game)
	public int		x;
	public int		y;
	public Image	texture;	// texture url
	public int		width;		// image width
	public int		height;		// image height
	public int		hwidth;		// hitbox
	public int		hheight;	// hitbox
	
	public Entity(int id, String name, int x, int y, int width, int height, int hwidth, int hheight, String texture) {
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.hwidth = hwidth;
		this.hheight = hheight;
		this.x = x;
		this.y = y;
		loadImage(texture);
		Log.info("loaded " + name);
	}
	
	public void draw(Graphics2D g2d, ImageObserver io) {
		g2d.drawImage(texture, x, y, width, height, io);
	}
	
	public abstract void update();
	
	private void loadImage(String texture) {
		try {
			this.texture = ImageIO.read(new File("resource/texture/entity/" + texture.toLowerCase()));
		} catch (IOException ex) {
			Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}