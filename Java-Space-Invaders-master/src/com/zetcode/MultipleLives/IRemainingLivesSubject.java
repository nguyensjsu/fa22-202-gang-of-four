package com.zetcode.MultipleLives;

import java.awt.Graphics;

public interface IRemainingLivesSubject {
    public void add(RemainingLivesObserver o);
    public void remove(RemainingLivesObserver o);
    public void notifyObservers();

    public void notifyObservers(Graphics g);
}