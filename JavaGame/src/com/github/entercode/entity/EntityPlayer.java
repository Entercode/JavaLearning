/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.entity;

import com.github.entercode.action.Action;
import java.awt.Point;

/**
 *
 * @author entercode
 */
public abstract class EntityPlayer extends Entity implements Action {

	public EntityPlayer(int id, String name, double hp, Point pos, int width, int height, int hwidth, int hheight, String texture) {
		super(id, name, hp, pos, width, height, hwidth, hheight, texture);
	}
	
}
