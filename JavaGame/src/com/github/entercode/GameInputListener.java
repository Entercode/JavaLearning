/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode;


import com.github.entercode.entity.player.Player;
import com.github.entercode.util.Log;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author entercode
 */
public class GameInputListener implements KeyListener {

@Override
public void keyTyped(KeyEvent e) {
}

@Override
public void keyPressed(KeyEvent e) {


	Player p = (Player) GameRegister.EntityRegister.get(0);
	switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			
			p.moveLeft();

			break;
		case KeyEvent.VK_RIGHT:
			
			p.moveRight();

			break;
		case KeyEvent.VK_UP:
			
			p.moveUp();

			break;
		case KeyEvent.VK_DOWN:
			
			p.moveDown();

			break;
		case KeyEvent.VK_SHIFT:

			break;
		case KeyEvent.VK_SPACE:

			break;
		case KeyEvent.VK_ESCAPE:

		break;
		default:
			break;

	}
}

@Override
public void keyReleased(KeyEvent e) {

}

}
