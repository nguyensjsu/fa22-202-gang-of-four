package com.zetcode.LiveScore;

import java.awt.Graphics;

public interface ILiveScoreSubject {
    public void attach(ILiveScoreObserver o);
    public void detach(ILiveScoreObserver o);
    public void notifyObservers();
}
