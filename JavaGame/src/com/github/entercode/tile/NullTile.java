/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.tile;

import java.awt.Graphics2D;

/**
 *
 * @author entercode
 */
public class NullTile extends Tile {

	public NullTile(int id, String name) {
		super(id, name);
	}
	
	@Override
	public void draw(Graphics2D g2d, int x, int y, int ox, int oy) {
		
	}

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
