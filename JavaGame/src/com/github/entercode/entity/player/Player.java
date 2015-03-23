/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.entity.player;

import com.github.entercode.action.Action;
import com.github.entercode.entity.Entity;
import com.github.entercode.entity.EntityPlayer;
import com.github.entercode.util.Log;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author entercode
 */
public class Player extends EntityPlayer {

	public Player(int id, String name, double hp, Point pos, int width, int height, int hwidth, int hheight, String texture) {
		super(id, name, hp, pos, width, height, hwidth, hheight, texture);
	}

	@Override
	public void moveLeft() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void moveRight() {
		this.pos.x += 10;
	}

	@Override
	public void moveUp() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void moveDown() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
