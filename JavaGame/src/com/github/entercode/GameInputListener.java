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

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getExtendedKeyCode()) {
            case KeyEvent.VK_LEFT:
                break;
            default:
                break;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
