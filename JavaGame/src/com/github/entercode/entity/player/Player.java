/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.entity.player;

import com.github.entercode.entity.EntityMob;

/**
 *
 * @author entercode
 */
public class Player extends EntityMob {

	public Player(int id, String name, double hp, int dir, double speed, int x, int y, int width, int height, int hwidth, int hheight, String texture) {
		super(id, name, hp, dir, speed, x, y, width, height, hwidth, hheight, texture);
	}

	@Override
	public void update() {
		
	}
	
}
