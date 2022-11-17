package utilities;

import game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public InputHandler(Game game){
        game.addKeyListener(this);
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
        toggleKey(e.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent e) {
        toggleKey(e.getKeyCode(), false);
    }

    
    /*
    public static final int VK_KP_UP          = 0xE0;
    public static final int VK_KP_DOWN        = 0xE1;
    public static final int VK_KP_LEFT        = 0xE2;
    public static final int VK_KP_RIGHT       = 0xE3;
     */
    
    public void toggleKey(int keyCode, boolean isPressed){
    	
    	System.err.println("keyCode: " + keyCode);
    	
        if(keyCode == KeyEvent.VK_KP_RIGHT || keyCode == 39)
            right.toggle(isPressed);
        if(keyCode == KeyEvent.VK_KP_LEFT || keyCode == 37)
            left.toggle(isPressed);
        if(keyCode == KeyEvent.VK_KP_UP || keyCode == 38)
            space.toggle(isPressed);
    }
}