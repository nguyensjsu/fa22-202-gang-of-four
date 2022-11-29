package com.zetcode.cheatcode;

public interface KeyEventDispenseChain {

	void setNextChain(KeyEventDispenseChain nextChain);
	
	void keyEvent(int key);
}