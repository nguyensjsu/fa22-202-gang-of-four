package com.zetcode.cheatcode;

import com.zetcode.SpaceInvaders;
import com.zetcode.utilites.SoundEffectPlayer;
import com.zetcode.utilites.SoundEffectTracks;

public class KeyQueue {

    static StringBuffer keyLogger = new StringBuffer();
    private static KeyQueue instance = null;
    
    private KeyQueue() {
    	
    }
    
    public static KeyQueue getInstance() {
        if (instance == null) {
        	instance = new KeyQueue();
        }
        return instance;
    }

    public synchronized void add(int keyCode) {

    	char value=(char)keyCode;  
    	//System.err.println("KeyLogger: " + value + " was pressed, value: " + keyCode);
    	keyLogger.append(value);
    	
    	switch (keyCode) {
    	case 49:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48;   
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
    		break;

    	case 50:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
    		reset();    		
    		break;
    		
    	case 51:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
    		reset();    		
    		break;
    		
    	case 52:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
    		reset();    		
    		break;
    		
    	case 53:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48;    		
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
    		reset();    		
    		break;

    	case 54:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
    		reset();    		
    		break;    		
    		
    	case 55:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48;  
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));    		
    		reset();    		
    		break;
    		
    	case 56:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48; 
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
    		reset();    		
    		break;
    		
    	case 57:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48;    		
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
    		reset();    		
    		break;
    		
    	case 58:
    		SpaceInvaders.getInstance().left_moves = keyCode-48;
    		SpaceInvaders.getInstance().right_moves = keyCode-48;    		
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.SpeedUp));
    		reset();    		
    		break;
    		
    	case 76:
    		reset();    		
    		break;    		
    		
    	case 108:
    		reset();    		
    		break;    		    		
    		
    	default:
    		break;    		
    	}
    	
    	
    	if(keyLogger.toString().toLowerCase().contains("bomb")) {    		
    		reset();    		
    		System.out.println("Bombing done");
    	} else if(keyLogger.toString().toLowerCase().contains("reset")) {
    		reset();
    		System.out.println("reset screen");    		
    	} else if(keyLogger.toString().toLowerCase().contains("007")) {
    		reset();    		
    	} else if(keyLogger.toString().toLowerCase().contains("music")) {
    		reset();
    	}
    }

    private void reset() {
    	keyLogger = new StringBuffer();
    }
}