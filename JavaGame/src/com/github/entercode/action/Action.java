/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.action;

/**
 * Basic Action Interface
 * This interface should be use to decide moving amount and animation
 * 
 * @author entercode
 */
public interface Action {
	
	public void move(int x, int y);
}
