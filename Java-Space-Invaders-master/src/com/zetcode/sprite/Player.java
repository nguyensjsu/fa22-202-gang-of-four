package com.zetcode.sprite;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.zetcode.Commons;
import com.zetcode.SpaceInvaders;
import com.zetcode.cheatcode.KeyEventDispenseChain;
import com.zetcode.utilites.SoundEffectPlayer;
import com.zetcode.utilites.SoundEffectTracks;

public class Player extends Sprite implements KeyEventDispenseChain {

    private int width;

	private KeyEventDispenseChain chain;
	
    public Player() {

        initPlayer();
    }

    private void initPlayer() {

        var playerImg = "Java-Space-Invaders-master/src/images/player.png";
        var ii = new ImageIcon(playerImg);

        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());

        int START_X = Commons.BOARD_WIDTH/2;
        setX(START_X);

        int START_Y = Commons.BOARD_HEIGHT-62;
        setY(START_Y);
    }

    public void act() {

        x += dx;

        if (x <= 2) {

            x = 2;
        }

        if (x >= Commons.BOARD_WIDTH - 2 * width) {

            x = Commons.BOARD_WIDTH - 2 * width;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = - SpaceInvaders.getInstance().left_moves;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = SpaceInvaders.getInstance().right_moves;
        }
        
        this.keyEvent(key);
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }

	@Override
	public void setNextChain(KeyEventDispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void keyEvent(int key) {
		// TODO Auto-generated method stub
		
		switch (key) {
    	case 49:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48;   
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));            
    		return;

    	case 50:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
            return;
    		
    	case 51:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
            return;
    		
    	case 52:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
            return;
    		
    	case 53:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48;    		
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));	
            return;

    	case 54:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
            return;    		
    		
    	case 55:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48;  
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
            return;
    		
    	case 56:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
            return;
    		
    	case 57:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48;    		
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
            return;
    		
    	case 58:
    		SpaceInvaders.getInstance().left_moves = key-48;
    		SpaceInvaders.getInstance().right_moves = key-48;    		
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
            return;
    	}
		
		if (this.chain!=null)
			this.chain.keyEvent(key);
	}
}
