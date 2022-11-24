package com.zetcode.LiveScore;

import java.awt.Graphics;

public interface ILiveScoreSubject {
    public void registerObserver(LiveScoreObserver o);
    public void removeObserver(LiveScoreObserver o);
    public void notifyObservers();
    public void notifyObservers(Graphics g);
}
