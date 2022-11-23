package com.zetcode.cheatcode;

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

    public synchronized void add(String value) {
    	System.err.print("KeyLogger: " + value + " was pressed");
    	
    	keyLogger.append(value);
    	if(keyLogger.toString().toLowerCase().contains("bomb")) {
    		reset();    		
    	} else if(keyLogger.toString().toLowerCase().contains("reset")) {
    		reset();
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