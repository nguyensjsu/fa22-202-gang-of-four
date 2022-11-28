package com.zetcode.utilites;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.zetcode.Board;
import com.zetcode.cheatcode.KeyQueue;

public class InputHandler implements KeyListener {
	
	private Board board = null;
	
    public InputHandler(Board board){
    	this.board = board;
    	this.board.addKeyListener(this);
    }

    public class Key{
        private boolean isKeyDown = false;
        public void toggle(boolean isKeyDown){
            this.isKeyDown = isKeyDown;
        }
        public boolean isKeyDown(){
            return isKeyDown;
        }
    }

    public Key left = new Key();
    public Key right = new Key();
    public Key space = new Key();

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    	board.keyPressed(e);
    	KeyQueue.getInstance().add(e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {
    	board.keyReleased(e);
    }


}