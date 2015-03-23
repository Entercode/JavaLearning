/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
	
	public Point	pos;		// upleft pos
	public double	vx = 0;
	public double	vy = 0;
	public double	ax = 0;
	public double	ay = 0;
	public double	gx = 0;
	public double	gy = 0.2;
	public double	rx = 0.08;
	public double	ry = 0;
	public double	move;	// amount of moving
	public double	hp;		// hitpoint
	
	public Image	texture;	// texture url
	
	public int		width;		// image width
	public int		height;		// image height
	public int		hwidth;		// hitbox
	public int		hheight;	// hitbox
	
	public Entity(int id, String name, double hp, Point pos, int width, int height, int hwidth, int hheight, String texture) {
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.pos = pos;
		loadImage(texture);
	}
	
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(texture, pos.x, pos.y, width, height, io);
	}
	
	private void loadImage(String texture) {
		try {
			this.texture = ImageIO.read(new File(texture));
		} catch (IOException ex) {
			Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}