/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author entercode
 */
public class GameInputListener implements KeyListener {
	
	public Key up		= new Key();
	public Key down		= new Key();
	public Key left		= new Key();
	public Key right	= new Key();
	public Key space	= new Key();
	public Key shift	= new Key();
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}
	
	public void toggleKey(int keycode, boolean pressed) {
		switch(keycode) {
			case KeyEvent.VK_UP:
				up.toggle(pressed);
				break;
			case KeyEvent.VK_DOWN:
				down.toggle(pressed);
				break;
			case KeyEvent.VK_LEFT:
				left.toggle(pressed);
				break;
			case KeyEvent.VK_RIGHT:
				right.toggle(pressed);
				break;
			case KeyEvent.VK_SPACE:
				space.toggle(pressed);
				break;
			case KeyEvent.VK_SHIFT:
				shift.toggle(pressed);
				break;
		}
	}

}
