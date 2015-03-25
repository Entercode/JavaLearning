/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

/**
 *
 * @author entercode
 */
public class Key {
	
	private boolean pressed = false;
	
	public void toggle(boolean pressed) {
		this.pressed = pressed;
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
}
