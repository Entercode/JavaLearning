/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.entity;

/**
 *
 * @author entercode
 */
public abstract class EntityMob extends Entity {
	
	protected double	hp		= 20;
	protected int		dir		= 0;
	protected double	speed	= 1;
	protected double	vx;
	protected double	vy;
	protected double	ax;
	protected double	ay;
	protected double	gx;
	protected double	gy;
	protected boolean	moving	= false;

	public EntityMob(int id, String name, double hp, int dir, double speed, int x, int y, int width, int height, int hwidth, int hheight, String texture) {
		super(id, name, x, y, width, height, hwidth, hheight, texture);
	}

	
}
