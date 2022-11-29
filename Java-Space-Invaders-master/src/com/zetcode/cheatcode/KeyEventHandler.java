package com.zetcode.cheatcode;

public abstract class KeyEventHandler {

	 public static int SPEED = 1;
	 public static int LIFE = 2;
	 public static int LEVEL_UP = 3;
	
	protected int mode;

	// next element in chain or responsibility
	protected KeyEventHandler nextHandler;

	public void setNextLogger(KeyEventHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void event(int e) {
		if (keyEvent(e)==false) {
			if (nextHandler != null) {
				nextHandler.event(e);
			}
		}
	}

	abstract protected boolean keyEvent(int e);
}
